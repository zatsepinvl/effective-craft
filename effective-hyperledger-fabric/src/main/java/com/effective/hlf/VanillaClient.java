package com.effective.hlf;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.GatewayRuntimeException;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.NetworkConfigurationException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.hyperledger.fabric.sdk.identity.X509Enrollment;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric.sdk.security.CryptoSuiteFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;

public class VanillaClient {
    public static void main(String[] args) throws IOException, InvalidArgumentException, TransactionException, NetworkConfigurationException, InterruptedException {
        Gateway.Builder builder = Gateway.createBuilder();


        // A wallet stores a collection of identities
        Path walletPath = Paths.get("identity", "user", "isabella", "wallet");
        Wallet wallet = Wallet.createFileSystemWallet(walletPath);
        String userName = "User1@org1.example.com";

        Path connectionProfile = Paths.get("gateway", "networkConnection.yaml");
        var gateway = builder.identity(wallet, userName)
                .networkConfig(connectionProfile)
                .discovery(false)
                .connect();


        var client = createClient(gateway.getIdentity());
        var networkConfig = NetworkConfig.fromYamlFile(Paths.get("gateway", "networkConnection.yaml").toFile());
        var channel = client.loadChannelFromConfig("mychannel",networkConfig);

        //Logger.getLogger(Channel.class).setLevel(Level.DEBUG);
        Configurator.setLevel("org.hyperledger.fabric.sdk", Level.DEBUG);

        channel.initialize();

        var log = LogFactory.getLog(VanillaClient.class);
        channel.registerBlockListener(new BlockListener() {
            @Override
            public void received(BlockEvent blockEvent) {
                log.info(blockEvent);
            }
        });
        channel.registerChaincodeEventListener(Pattern.compile(".*"), Pattern.compile(".*"), new ChaincodeEventListener() {
            @Override
            public void received(String handle, BlockEvent blockEvent, ChaincodeEvent chaincodeEvent) {
                System.out.println("received");
                log.info(blockEvent);
                log.info(chaincodeEvent);
            }
        });
        //Thread.sleep(10000000);
    }

    private static HFClient createClient(Wallet.Identity identity) {
        Enrollment enrollment = new X509Enrollment(identity.getPrivateKey(), identity.getCertificate());
        User user = new User() {
            @Override
            public String getName() {
                return "gateway";
            }

            @Override
            public Set<String> getRoles() {
                return Collections.emptySet();
            }

            @Override
            public String getAccount() {
                return "";
            }

            @Override
            public String getAffiliation() {
                return "";
            }

            @Override
            public Enrollment getEnrollment() {
                return enrollment;
            }

            @Override
            public String getMspId() {
                return identity.getMspId();
            }
        };
        HFClient client = HFClient.createNewInstance();

        try {
            CryptoSuite cryptoSuite = CryptoSuiteFactory.getDefault().getCryptoSuite();
            client.setCryptoSuite(cryptoSuite);
            client.setUserContext(user);
        } catch (ClassNotFoundException | CryptoException | IllegalAccessException | NoSuchMethodException
                | InstantiationException | InvalidArgumentException | InvocationTargetException e) {
            throw new GatewayRuntimeException("Failed to configure client", e);
        }

        return client;
    }
}

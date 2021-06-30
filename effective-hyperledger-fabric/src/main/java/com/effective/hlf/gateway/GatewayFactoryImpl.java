package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Wallet;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GatewayFactoryImpl implements GatewayFactory {
    public Gateway createGateway() throws IOException {
        Gateway.Builder builder = Gateway.createBuilder();
        Path walletPath = Paths.get("identity", "user", "isabella", "wallet");
        Wallet wallet = Wallet.createFileSystemWallet(walletPath);

        String userName = "User1@org1.example.com";
        Path connectionProfile = Paths.get("gateway", "networkConnection.yaml");

        TransactionEventManager txEventManager = new TransactionEventManager();
        return builder
                .identity(wallet, userName)
                .networkConfig(connectionProfile)
                .discovery(false)
                .commitHandler((transactionId, network) ->
                        new DurableCommitHandler(network, transactionId, txEventManager)
                )
                .connect();
    }
}

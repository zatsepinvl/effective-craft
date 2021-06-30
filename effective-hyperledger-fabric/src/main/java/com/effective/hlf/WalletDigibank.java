package com.effective.hlf;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.Wallet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalletDigibank {
    public static void main(String[] args) {
        try {
            // A wallet stores a collection of identities
            Path walletPath = Paths.get("identity", "user", "balaji", "wallet");
            Wallet wallet = Wallet.createFileSystemWallet(walletPath);

            // Location of credentials to be stored in the wallet
            Path credentialPath = Paths.get("fabric-samples", "basic-network", "crypto-config",
                    "peerOrganizations", "org1.example.com", "users", "Admin@org1.example.com", "msp");
            Path certificatePem = credentialPath.resolve(Paths.get("signcerts",
                    "Admin@org1.example.com-cert.pem"));
            Path privateKey = credentialPath.resolve(Paths.get("keystore",
                    "cd96d5260ad4757551ed4a5a991e62130f8008a0bf996e4e4b84cd097a747fec_sk"));

            // Load credentials into wallet
            String identityLabel = "Admin@org1.example.com";
            Wallet.Identity identity = Wallet.Identity.createIdentity("Org1MSP", Files.newBufferedReader(certificatePem), Files.newBufferedReader(privateKey));

            wallet.put(identityLabel, identity);

        } catch (IOException e) {
            System.err.println("Error adding to wallet");
            e.printStackTrace();
        }
    }
}

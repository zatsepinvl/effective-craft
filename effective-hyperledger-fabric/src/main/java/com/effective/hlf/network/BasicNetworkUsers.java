package com.effective.hlf.network;

import com.effective.hlf.gateway.UserIdentity;
import com.effective.hlf.resource.ResourceUtils;
import org.hyperledger.fabric.gateway.Wallet;

import java.io.IOException;
import java.nio.file.Path;

public class BasicNetworkUsers {
    public static UserIdentity getIsabellaUserIdentity() {
        return getUserIdentity("User1@org1.example.com", "identity/user/isabella/wallet");
    }

    public static UserIdentity getBalajiUserIdentity() {
        return getUserIdentity("Admin@org1.example.com", "identity/user/balaji/wallet");
    }

    private static UserIdentity getUserIdentity(String username, String walletResource) {
        Path walletPath = ResourceUtils.getResourcePath(walletResource);
        Wallet wallet = getWallet(walletPath);
        return new UserIdentity(wallet, username);
    }

    private static Wallet getWallet(Path walletPath) {
        try {
            return Wallet.createFileSystemWallet(walletPath);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create wallet from file system path.", e);
        }
    }


}

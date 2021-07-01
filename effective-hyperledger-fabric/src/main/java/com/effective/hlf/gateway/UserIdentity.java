package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Wallet;

import java.nio.file.Path;

public class UserIdentity {
    private final Wallet walletPath;
    private final String username;

    public UserIdentity(Wallet wallet, String username) {
        this.walletPath = wallet;
        this.username = username;
    }

    public Wallet getWallet() {
        return walletPath;
    }

    public String getUsername() {
        return username;
    }
}

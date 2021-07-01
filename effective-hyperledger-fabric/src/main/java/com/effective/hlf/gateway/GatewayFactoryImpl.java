package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Gateway;

import java.io.IOException;
import java.nio.file.Path;

public class GatewayFactoryImpl implements GatewayFactory {
    private final TransactionEventManager txEventManager;
    private final UserIdentity user;
    private final Path networkConfigFile;

    public GatewayFactoryImpl(TransactionEventManager txEventManager, UserIdentity user, Path networkConfigFile) {
        this.txEventManager = txEventManager;
        this.user = user;
        this.networkConfigFile = networkConfigFile;
    }

    @Override
    public Gateway createGateway() throws IOException {
        return Gateway.createBuilder()
                .identity(user.getWallet(), user.getUsername())
                .networkConfig(networkConfigFile)
                .discovery(false)
                .commitHandler((txId, network) -> new TransactionCommitHandler(network, txId, txEventManager))
                .connect();
    }
}

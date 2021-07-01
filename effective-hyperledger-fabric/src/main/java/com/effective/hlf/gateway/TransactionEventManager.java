package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Network;

public interface TransactionEventManager {
    void addTransactionListener(Network network, String txId, TransactionListener listener);

    void removeTransactionListener(Network network, String txId);
}

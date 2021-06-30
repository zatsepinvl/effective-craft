package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.BlockEvent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

public class TransactionEventManager {
    private final ConcurrentMap<String, TxListener> txListeners = new ConcurrentHashMap<>();
    private final ConcurrentMap<Network, Consumer<BlockEvent>> blockListeners = new ConcurrentHashMap<>();

    public void addListener(Network network, String txId, TxListener listener) {
        txListeners.put(txId, listener);
        if (blockListeners.containsKey(network)) {
            return;
        }
        Consumer<BlockEvent> blockListener = (blockEvent) -> {
            blockEvent.getTransactionEvents().forEach(tx -> {
                if (txListeners.containsKey(tx.getTransactionID())) {
                    txListeners.get(tx.getTransactionID()).onTransaction(tx);
                }
            });
        };
        blockListeners.put(network, blockListener);
        network.addBlockListener(blockListener);
    }

    public void removeListener(String txId) {
        txListeners.remove(txId);
    }
}

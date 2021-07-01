package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.sdk.BlockEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

public class TransactionEventManagerImpl implements TransactionEventManager, Consumer<BlockEvent> {
    private final Map<String, TransactionListener> txListeners = new ConcurrentHashMap<>();
    private final Map<Network, Consumer<BlockEvent>> blockListeners = new HashMap<>();
    private final Map<Network, Integer> networkListeners = new HashMap<>();

    @Override
    public void addTransactionListener(Network network, String txId, TransactionListener listener) {
        synchronized (networkListeners) {
            txListeners.put(txId, listener);
            networkListeners.merge(network, 1, Integer::sum);
            if (blockListeners.containsKey(network)) {
                return;
            }
            blockListeners.put(network, this);
            network.addBlockListener(0, this);
        }
    }

    @Override
    public void removeTransactionListener(Network network, String txId) {
        synchronized (networkListeners) {
            txListeners.remove(txId);
            int left = networkListeners.merge(network, -1, Integer::sum);
            if (left == 0) {
                network.removeBlockListener(this);
                blockListeners.remove(network);
            }
        }
    }

    @Override
    public void accept(BlockEvent blockEvent) {
        blockEvent.getTransactionEvents().forEach(tx -> {
            if (txListeners.containsKey(tx.getTransactionID())) {
                txListeners.get(tx.getTransactionID()).onTransaction(tx);
            }
        });
    }


}

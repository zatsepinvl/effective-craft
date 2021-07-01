package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.spi.CommitHandler;
import org.hyperledger.fabric.sdk.BlockEvent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TransactionCommitHandler implements CommitHandler {

    private final Network network;
    private final String txId;
    private final TransactionEventManager txEventManager;
    private final BlockingQueue<BlockEvent.TransactionEvent> transactionEvents;

    public TransactionCommitHandler(Network network, String txId, TransactionEventManager txEventManager) {
        this.network = network;
        this.txId = txId;
        this.txEventManager = txEventManager;
        transactionEvents = new ArrayBlockingQueue<>(1);
    }

    @Override
    public void startListening() {
        txEventManager.addTransactionListener(network, txId, transactionEvents::add);
    }

    @Override
    public void waitForEvents(long timeout, TimeUnit timeUnit) throws InterruptedException {
        BlockEvent.TransactionEvent tx = transactionEvents.take();
        if (!tx.isValid()) {
            throw new RuntimeException("Transaction is not valid: " + txId);
        }
        txEventManager.removeTransactionListener(network, txId);
    }

    @Override
    public void cancelListening() {
        txEventManager.removeTransactionListener(network, txId);
    }
}

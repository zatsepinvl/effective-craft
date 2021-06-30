package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.spi.CommitHandler;
import org.hyperledger.fabric.sdk.BlockEvent;

import java.util.concurrent.*;

public class DurableCommitHandler implements CommitHandler {

    private final Network network;
    private final String txId;
    private final TransactionEventManager txEventManager;
    private final BlockingQueue<BlockEvent.TransactionEvent> transactionEvents;

    public DurableCommitHandler(Network network, String txId, TransactionEventManager txEventManager) {
        this.network = network;
        this.txId = txId;
        this.txEventManager = txEventManager;
        transactionEvents = new ArrayBlockingQueue<>(1);
    }

    @Override
    public void startListening() {
        System.out.println("startListening");
        txEventManager.addListener(network, txId, transactionEvents::add);
    }

    @Override
    public void waitForEvents(long timeout, TimeUnit timeUnit) throws ContractException, TimeoutException, InterruptedException {
        System.out.println("waitForEvents");
        BlockEvent.TransactionEvent tx = transactionEvents.take();
        if (!tx.isValid()) {
            throw new RuntimeException("Transaction is not valid: " + txId);
        }
        txEventManager.removeListener(txId);
    }

    @Override
    public void cancelListening() {
        System.out.println("cancelListening");
        txEventManager.removeListener(txId);
    }
}

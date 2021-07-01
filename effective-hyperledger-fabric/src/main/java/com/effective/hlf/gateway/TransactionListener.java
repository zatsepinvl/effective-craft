package com.effective.hlf.gateway;

import org.hyperledger.fabric.sdk.BlockEvent;

public interface TransactionListener {
    void onTransaction(BlockEvent.TransactionEvent tx);
}

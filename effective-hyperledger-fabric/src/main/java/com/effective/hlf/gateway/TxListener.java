package com.effective.hlf.gateway;

import org.hyperledger.fabric.sdk.BlockEvent;

public interface TxListener {
    void onTransaction(BlockEvent.TransactionEvent tx);
}

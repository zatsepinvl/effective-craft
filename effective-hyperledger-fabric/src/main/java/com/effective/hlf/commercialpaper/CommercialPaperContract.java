package com.effective.hlf.commercialpaper;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;

import java.util.concurrent.TimeoutException;

public class CommercialPaperContract {
    private static final String CONTRACT_CHAINCODE_ID = "papercontract";
    private static final String CONTRACT_NAME = "org.papernet.commercialpaper";
    private static final String CHANNEL_NAME = "mychannel";

    public CommercialPaper issue(Gateway gateway, String... args) throws ContractException, InterruptedException, TimeoutException {
        var contract = getContract(gateway);
        var response = contract.submitTransaction("issue", args);
        return CommercialPaper.deserialize(response);
    }

    public CommercialPaper buy(Gateway gateway, String... args) throws ContractException, InterruptedException, TimeoutException {
        var contract = getContract(gateway);
        var response = contract.submitTransaction("buy", args);
        return CommercialPaper.deserialize(response);
    }

    private Contract getContract(Gateway gateway) {
        Network network = gateway.getNetwork(CHANNEL_NAME);
        return network.getContract(CONTRACT_CHAINCODE_ID, CONTRACT_NAME);
    }
}

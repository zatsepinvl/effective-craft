/*
SPDX-License-Identifier: Apache-2.0
*/

package com.effective.hlf;

import com.effective.hlf.commercialpaper.CommercialPaper;
import com.effective.hlf.gateway.GatewayFactory;
import com.effective.hlf.gateway.GatewayFactoryImpl;
import com.effective.hlf.gateway.GatewayPool;
import com.effective.hlf.gateway.GatewayPoolImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;

import java.util.concurrent.TimeoutException;

public class Issue {

    public static void main(String[] args) throws Exception {
        Configurator.setLevel("org.hyperledger.fabric.sdk", Level.DEBUG);

        GatewayFactory factory = new GatewayFactoryImpl();
        GatewayPool gatewayPool = new GatewayPoolImpl(2, factory);
        Gateway gateway = gatewayPool.getGateway();
        issue(gateway);
    }

    private static void issue(Gateway gateway) throws ContractException, InterruptedException, TimeoutException {
        String contractName = "papercontract";
        Network network = gateway.getNetwork("mychannel");
        Contract contract = network.getContract(contractName, "org.papernet.commercialpaper");
        // Issue commercial paper
        System.out.println("Submit commercial paper issue transaction.");
        var start = System.currentTimeMillis();
        byte[] response = contract.submitTransaction("issue", "MagnetoCorp", "00003", "2020-05-31", "2020-11-30", "5000000");
        var end = System.currentTimeMillis();
        System.out.println("Elapsed seconds: " + (end - start) / 1000);
        System.out.println("Process issue transaction response.");
        CommercialPaper paper = CommercialPaper.deserialize(response);
        System.out.println(paper);
    }

}

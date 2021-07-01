/*
SPDX-License-Identifier: Apache-2.0
*/

package com.effective.hlf;

import com.effective.hlf.commercialpaper.CommercialPaperContract;
import com.effective.hlf.gateway.*;
import com.effective.hlf.logging.LoggingUtils;
import com.effective.hlf.network.BasicNetwork;
import com.effective.hlf.network.BasicNetworkUsers;
import org.apache.logging.log4j.Level;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;

import java.nio.file.Path;
import java.util.concurrent.TimeoutException;

public class Buy {

    public static void main(String[] args) throws InterruptedException, ContractException, TimeoutException {
        LoggingUtils.setHlfSdkGlobalLogLevel(Level.INFO);

        UserIdentity isabellaUser = BasicNetworkUsers.getBalajiUserIdentity();
        Path networkConfigFile = BasicNetwork.getNetworkConfigPath();

        TransactionEventManager eventManager = new TransactionEventManagerImpl();
        GatewayFactory factory = new GatewayFactoryImpl(eventManager, isabellaUser, networkConfigFile);
        GatewayPool gatewayPool = new GatewayPoolImpl(2, factory);
        Gateway gateway = gatewayPool.getGateway();

        var contract = new CommercialPaperContract();
        var result = contract.buy(gateway, "MagnetoCorp", "00003", "MagnetoCorp", "DigiBank", "4900000", "2020-05-31");
        System.out.println(result.toString());
    }

}

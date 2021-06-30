/*
SPDX-License-Identifier: Apache-2.0
*/

package com.effective.hlf;

import com.effective.hlf.commercialpaper.CommercialPaper;
import org.hyperledger.fabric.gateway.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.*;

public class Buy {

    private static final String ENVKEY = "CONTRACT_NAME";

    public static void main(String[] args) throws IOException, BrokenBarrierException, InterruptedException {
        Gateway.Builder builder = Gateway.createBuilder();


        // A wallet stores a collection of identities
        Path walletPath = Paths.get("identity", "user", "balaji", "wallet");
        Wallet wallet = Wallet.createFileSystemWallet(walletPath);

        String userName = "Admin@org1.example.com";

        Path connectionProfile = Paths.get("gateway", "networkConnection.yaml");

        // Set connection options on the gateway builder
        builder.identity(wallet, userName).networkConfig(connectionProfile).discovery(false);

        // Connect to gateway using application specified parameters
        int n = 2;
        CyclicBarrier barrier = new CyclicBarrier(n + 1);
        Gateway gateway = builder.connect();
        ExecutorService executor = Executors.newFixedThreadPool(n);
        Runnable task = () -> {
            try {
                barrier.await();
                buy(gateway);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < n; i++) {
            executor.submit(task);
        }
        barrier.await();
        executor.shutdown();
        executor.awaitTermination(4, TimeUnit.SECONDS);
        gateway.close();
    }

    private static void buy(Gateway gateway) throws ContractException, InterruptedException, TimeoutException {
        String contractName = "papercontract";
        // get the name of the contract, in case it is overridden
        Map<String, String> envvar = System.getenv();
        if (envvar.containsKey(ENVKEY)) {
            contractName = envvar.get(ENVKEY);
        }

        // Access PaperNet network
        System.out.println("Use network channel: mychannel.");
        Network network = gateway.getNetwork("mychannel");

        // Get addressability to commercial paper contract
        System.out.println("Use org.papernet.commercialpaper smart contract.");
        Contract contract = network.getContract(contractName, "org.papernet.commercialpaper");

        // Buy commercial paper
        System.out.println("Submit commercial paper buy transaction.");
        byte[] response = contract.submitTransaction("buy", "MagnetoCorp", "00003", "MagnetoCorp", "DigiBank", "4900000", "2020-05-31");

        // Process response
        System.out.println("Process buy transaction response.");
        CommercialPaper paper = CommercialPaper.deserialize(response);
    }

}

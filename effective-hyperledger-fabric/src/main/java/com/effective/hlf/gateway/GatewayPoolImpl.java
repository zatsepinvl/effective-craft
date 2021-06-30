package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Gateway;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GatewayPoolImpl implements GatewayPool {

    private final List<Gateway> gateways;
    private final AtomicInteger pointer;

    public GatewayPoolImpl(int count, GatewayFactory gatewayFactory) {
        gateways = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            try {
                gateways.add(gatewayFactory.createGateway());
            } catch (IOException e) {
                //ToDo handle exception
                e.printStackTrace();
            }
        }
        pointer = new AtomicInteger(0);
    }

    @Override
    public Gateway getGateway() {
        int nextIndex = Math.abs(pointer.getAndIncrement() % gateways.size());
        return gateways.get(nextIndex);
    }
}

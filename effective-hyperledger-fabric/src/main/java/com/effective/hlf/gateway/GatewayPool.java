package com.effective.hlf.gateway;

import org.hyperledger.fabric.gateway.Gateway;

public interface GatewayPool {
    Gateway getGateway();
}

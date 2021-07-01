package com.effective.hlf.network;

import com.effective.hlf.resource.ResourceUtils;

import java.nio.file.Path;

public class BasicNetwork {
    public static Path getNetworkConfigPath() {
        return ResourceUtils.getResourcePath("gateway/networkConnection.yaml");
    }
}

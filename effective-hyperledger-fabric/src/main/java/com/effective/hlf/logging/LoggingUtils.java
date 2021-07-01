package com.effective.hlf.logging;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggingUtils {

    public static void setHlfSdkGlobalLogLevel(Level level) {
        Configurator.setLevel("org.hyperledger.fabric", level);
    }

}

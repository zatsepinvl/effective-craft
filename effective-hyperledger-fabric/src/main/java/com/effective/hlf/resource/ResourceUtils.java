package com.effective.hlf.resource;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

public class ResourceUtils {
    public static Path getResourcePath(String resource) {
        try {
            return Path.of(Objects.requireNonNull(ResourceUtils.class.getClassLoader().getResource(resource)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

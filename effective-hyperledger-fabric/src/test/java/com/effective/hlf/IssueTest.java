package com.effective.hlf;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.containers.wait.strategy.WaitAllStrategy;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    @ClassRule
    public static DockerComposeContainer network =
            new DockerComposeContainer(new File("dev-network/docker-compose.yml"))
                    .waitingFor("cli", Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(30)));

    {
        network.start();
    }

    @Test
    public void test() {
    }
}
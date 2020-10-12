package com.effective.playground.spring.hystrix

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PingPongService(
        private val pingPongProps: PingPongConfigProperties,
        private val restTemplate: RestTemplate
) {
    @HystrixCommand(fallbackMethod = "pingFallback")
    fun ping(): String {
        return restTemplate.getForObject(pingPongProps.pingServerUrl + "/ping", String::class.java)
                ?: throw RuntimeException("pong not found")
    }

    fun pingFallback(): String {
        return "Cloud Native Java (O'Reilly)"
    }
}
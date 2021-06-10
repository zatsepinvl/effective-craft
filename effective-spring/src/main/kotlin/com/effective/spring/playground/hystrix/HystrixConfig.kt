package com.effective.playground.spring.hystrix

import com.effective.playground.spring.annotation.Module
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker

@Module
@EnableCircuitBreaker
@EnableConfigurationProperties(PingPongConfigProperties::class)
class HystrixConfig {
}
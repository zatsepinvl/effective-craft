package com.effective.playground.spring.hystrix

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("ping-pong")
@ConstructorBinding
class PingPongConfigProperties(
        val pingServerUrl: String
)
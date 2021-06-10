package com.effective.playground.spring.hystrix

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hystrix")
class HystrixPingPongController(
        private val pingPongService: PingPongService
) {

    @GetMapping("/ping")
    fun pingGet(): String {
        return "pong"
    }

    @GetMapping("/ping/start")
    fun pingPost(): String {
        return pingPongService.ping()
    }

}
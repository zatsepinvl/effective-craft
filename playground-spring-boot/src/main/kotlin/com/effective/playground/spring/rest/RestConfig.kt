package com.effective.playground.spring.rest

import com.effective.playground.spring.annotation.Module
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@Module
class RestConfig {

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.build();
    }
}
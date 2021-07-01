package com.effective.playground.spring

import com.effective.playground.spring.cache.CacheConfig
import com.effective.playground.spring.permissions.PermissionConfig
import com.effective.playground.spring.rest.RestConfig
import com.effective.playground.spring.security.SecurityConfig
import com.effective.playground.spring.swagger.SwaggerConfig
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableAutoConfiguration
@Import(
        CacheConfig::class,
        PermissionConfig::class,
        RestConfig::class,
        SecurityConfig::class,
        SwaggerConfig::class
)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

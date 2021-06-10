package com.effective.playground.spring.keycloak

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "keycloak")
data class KeycloakProps(
        val authServerUrl: String,
        val realm: String,
        val resource: String,
        val publicClient: Boolean
)

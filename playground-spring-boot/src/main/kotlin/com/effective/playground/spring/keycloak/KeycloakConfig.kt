package com.effective.playground.spring.keycloak

import org.keycloak.adapters.KeycloakDeployment
import org.keycloak.adapters.KeycloakDeploymentBuilder
import org.keycloak.representations.adapters.config.AdapterConfig
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(KeycloakProps::class)
class KeycloakConfig(
        private val keycloakProps: KeycloakProps
) {

    @Bean
    fun keycloakDeployment(): KeycloakDeployment {
        val adapterConfig = AdapterConfig().apply {
            authServerUrl = keycloakProps.authServerUrl
            realm = keycloakProps.realm
            resource = keycloakProps.resource
            isPublicClient = keycloakProps.publicClient
        }
        return KeycloakDeploymentBuilder.build(adapterConfig)
    }
}
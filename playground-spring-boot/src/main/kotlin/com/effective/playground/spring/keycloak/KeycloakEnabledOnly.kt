package com.effective.playground.spring.keycloak

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty

@ConditionalOnProperty(value = ["keycloak.enabled"], havingValue = "true")
annotation class KeycloakEnabledOnly
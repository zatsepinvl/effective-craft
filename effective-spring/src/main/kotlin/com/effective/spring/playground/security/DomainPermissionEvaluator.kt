package com.effective.playground.spring.security

import org.springframework.security.core.userdetails.User

interface DomainPermissionEvaluator {
    val targetObjectType: String
    fun hasPermission(user: User, targetId: String, permission: Any): Boolean
}
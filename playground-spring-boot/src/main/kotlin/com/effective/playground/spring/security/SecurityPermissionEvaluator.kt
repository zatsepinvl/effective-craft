package com.effective.playground.spring.security

import org.springframework.security.access.PermissionEvaluator
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.io.Serializable

@Component
class SecurityPermissionEvaluator : PermissionEvaluator {
    override fun hasPermission(authentication: Authentication?, targetDomainObject: Any?, permission: Any?): Boolean {
        return authentication?.authorities?.any {
            it.authority == "$permission:$targetDomainObject"
        } ?: false
    }

    override fun hasPermission(authentication: Authentication?, targetId: Serializable?, targetType: String?, permission: Any?): Boolean {
        TODO("Not yet implemented")
    }

}
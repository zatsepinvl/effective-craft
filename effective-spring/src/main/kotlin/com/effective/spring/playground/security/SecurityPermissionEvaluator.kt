package com.effective.playground.spring.security

import org.springframework.security.access.PermissionEvaluator
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.io.Serializable

@Component
class SecurityPermissionEvaluator(
        domainPermissionEvaluators: List<DomainPermissionEvaluator>
) : PermissionEvaluator {

    private val domainPermissionEvaluatorsMap =
            domainPermissionEvaluators.groupBy {
                it.targetObjectType
            }

    override fun hasPermission(authentication: Authentication, targetObject: Any?, permission: Any): Boolean {
        //for static permissions
        if (targetObject == null) {
            return authentication.authorities
                    ?.any { it.authority == "$permission" } ?: false
        } else {
            throw IllegalArgumentException("targetObject is not support");
        }
    }

    //for dynamic permissions
    override fun hasPermission(authentication: Authentication, targetId: Serializable, targetType: String, permission: Any): Boolean {
        return domainPermissionEvaluatorsMap[targetType]?.all {
            it.hasPermission(authentication.principal as User, targetId as String, permission)
        } ?: throw IllegalArgumentException("Unknown permission targetType $targetType")
    }

}
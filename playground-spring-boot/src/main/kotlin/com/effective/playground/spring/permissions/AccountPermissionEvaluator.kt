package com.effective.playground.spring.permissions

import com.effective.playground.spring.security.DomainPermissionEvaluator
import com.effective.playground.spring.utils.name
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component

@Component
class AccountPermissionEvaluator(
        private val accountRepository: AccountRepository
) : DomainPermissionEvaluator {

    override val targetObjectType = Account::class.name

    override fun hasPermission(user: User, targetId: String, permission: Any): Boolean {
        val isOwner = accountRepository.getAccount(targetId).ownerUserId == user.username
        return when (permission) {
            "account:delete" -> isOwner
            "account:read" -> isOwner
            else -> throw IllegalArgumentException("Unknown permission $permission")
        }
    }
}

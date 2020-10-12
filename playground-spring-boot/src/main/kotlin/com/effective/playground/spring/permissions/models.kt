package com.effective.playground.spring.permissions

import com.effective.playground.spring.utils.name

data class Account(
        val id: String,
        val ownerUserId: String
) {
    companion object {
        val name = Account::class.name
    }
}

data class Post(
        val id: String,
        val accountId: String,
        val content: String
)


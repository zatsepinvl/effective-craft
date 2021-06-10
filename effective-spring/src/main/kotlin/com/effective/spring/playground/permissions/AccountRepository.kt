package com.effective.playground.spring.permissions

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository

private val accounts = mutableListOf(
        Account("a1", "user1"),
        Account("a2", "user2")
)

private val posts = mutableListOf(
        Post("p1", "a1", "c1"),
        Post("p2", "a2", "c2")
)

@Repository
class AccountRepository {
    @Cacheable("accounts")
    fun getAccounts() = accounts

    @Cacheable("account")
    fun getAccount(accountId: String): Account {
        simulateSlowService()
        return accounts.find { it.id == accountId }!!
    }

    fun createAccount(account: Account) {
        accounts.add(account)
    }

    fun deleteAccount(accountId: String) {
        accounts.removeIf { it.id == accountId }
    }

    private fun simulateSlowService() {
        try {
            val time = 2000L;
            Thread.sleep(time);
        } catch (e: InterruptedException) {
            throw  IllegalStateException(e);
        }
    }
}
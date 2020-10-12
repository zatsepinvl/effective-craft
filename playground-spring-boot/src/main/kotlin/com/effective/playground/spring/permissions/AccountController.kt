package com.effective.playground.spring.permissions

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
//GetMappings are used only for convenient invocation from browser
class AccountController(
        private val accountRepository: AccountRepository
) {

    @GetMapping
    @PreAuthorize("hasPermission(null, 'accounts:readAll')")
    fun getAllAccounts(@AuthenticationPrincipal user: User): List<Account> {
        return accountRepository.getAccounts()
    }

    @GetMapping("/create")
    @PreAuthorize("hasPermission(null, 'accounts:create')")
    fun createAccount(@AuthenticationPrincipal user: User): Account {
        val nextAccountId = accountRepository.getAccounts().size + 1
        val account = Account("a$nextAccountId", user.username)
        accountRepository.createAccount(account)
        return account
    }

    @GetMapping("/{accountId}")
    @PreAuthorize("hasPermission(#accountId, 'Account', 'account:read')")
    fun getAccount(@PathVariable accountId: String): Account {
        return accountRepository.getAccount(accountId)
    }

    @GetMapping("/delete/{accountId}")
    @PreAuthorize("hasPermission(#accountId, 'Account', 'account:delete')")
    fun deleteAccount(@PathVariable accountId: String): String {
        accountRepository.deleteAccount(accountId)
        return "OK"
    }

}
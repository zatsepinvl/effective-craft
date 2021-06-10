package com.effective.playground.spring.security

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogoutController {
    @GetMapping("/logout")
    fun logout() {
        SecurityContextHolder.getContext().authentication = null
    }
}
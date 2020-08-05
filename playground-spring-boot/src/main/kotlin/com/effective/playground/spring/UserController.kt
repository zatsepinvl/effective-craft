package com.effective.playground.spring

import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {

    @GetMapping("/me")
    fun me(@AuthenticationPrincipal user: User): Any {
        return user
    }

    @GetMapping("/{userId}")
    @PreAuthorize("hasPermission(#userId, 'users:read')")
    fun myRoles(@PathVariable userId: String): String {
        return "success"
    }
}
package com.effective.playground.spring.security

import com.effective.playground.spring.annotation.Module
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Module
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/accounts/**").authenticated()
                .anyRequest().permitAll()
                .and().httpBasic()
                .and()
                .logout()
                .permitAll()
    }

    @Bean
    override fun userDetailsService(): UserDetailsService? {
        val user1: UserDetails = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("user")
                .roles(USER)
                //assume that we take roles and permissions from database
                //users have many roles, roles have many permissions
                //here we can define only static permissions
                .authorities(
                        "accounts:create",
                        "accounts:read"
                )
                .build()

        val user2: UserDetails = User.withDefaultPasswordEncoder()
                .username("user2")
                .password("user")
                .roles(USER)
                //assume that we take roles and permissions from database
                //users have many roles, roles have many permissions
                //here we can define only static permissions
                .authorities(
                        "accounts:create",
                        "accounts:read"
                )
                .build()

        val admin: UserDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles(ADMIN)
                .authorities(
                        "accounts:readAll"
                )
                .build()

        return InMemoryUserDetailsManager(user1, user2, admin)
    }
}
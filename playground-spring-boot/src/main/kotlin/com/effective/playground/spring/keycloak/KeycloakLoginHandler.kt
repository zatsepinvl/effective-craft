package com.effective.playground.spring.keycloak

import org.keycloak.adapters.KeycloakDeployment
import org.keycloak.adapters.ServerRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.URI

private const val PATH_PREFIX = "/keycloak"
private const val ROOT_URL = "http://localhost:8080"

@RestController
@RequestMapping(PATH_PREFIX)
class KeycloakLoginHandler(
        private val keycloakDeployment: KeycloakDeployment
) {

    @GetMapping("/login")
    fun login(
            @RequestParam(name = "rememberMe", required = false) rememberMe: Boolean?
    ): ResponseEntity<Any?>? {
        val redirectUri = URI.create("$ROOT_URL$PATH_PREFIX/code")
        val redirectUrl = URI.create(
                "http://localhost:8081/auth/realms/master/protocol/openid-connect/auth"
                        + "?client_id=spring-boot"
                        + "&response_type=code"
                        + "&scope=openid"
                        + "&redirect_uri=$redirectUri"
                        + "&prompt=select_account"
                        + if (rememberMe == true) "&state=rememberMe" else ""
        )
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(redirectUrl)
                .build<Any>()
    }

    @GetMapping(path = ["/code"], produces = ["application/text"])
    fun handleCode(
            @RequestParam(name = "code") code: String,
            @RequestParam(name = "session_state", required = false) sessionState: String?,
            @RequestParam(name = "state", required = false) state: String?
    ): ResponseEntity<Any?>? {
        var redirectUri = "$ROOT_URL$PATH_PREFIX/code"
        val token = ServerRequest.invokeAccessCodeToToken(
                keycloakDeployment, code, redirectUri, sessionState
        )

        redirectUri = "$ROOT_URL$PATH_PREFIX/login/refresh"
        if (state == "rememberMe") {
            redirectUri = "$redirectUri?refreshToken=${token.refreshToken}"
        }

        token.refreshExpiresIn

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(redirectUri))
                .build()
    }

    @GetMapping("/login/refresh")
    fun handlerRefreshToken(
            @RequestParam(name = "refreshToken", required = false) refreshToken: String?
    ): Any {
        return ServerRequest.invokeRefresh(keycloakDeployment, refreshToken)
    }


}
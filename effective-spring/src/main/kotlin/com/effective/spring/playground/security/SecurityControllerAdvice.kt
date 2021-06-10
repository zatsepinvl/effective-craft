package com.effective.playground.spring.security

import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
@ResponseBody
class SecurityControllerAdvice {

    @ExceptionHandler(AccessDeniedException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun forbidden(exception: AccessDeniedException): String? {
        return exception.message
    }

}

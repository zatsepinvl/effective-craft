package com.effective.spring.mongodb

import org.springframework.data.annotation.Id

data class Data(
    @Id val id: String,
    val value: Int
)
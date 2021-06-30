package com.effective.spring.mongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MongodbPlaygroundApp

fun main(args: Array<String>) {
    runApplication<MongodbPlaygroundApp>(*args)
}

package com.effective.kotlin.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.Duration
import java.time.Instant

fun main(): Unit = runBlocking {
    val start = Instant.now()
    val result1 =  load("1")
    val result2 = load("2")
    val end = Instant.now()
    println("Time passed: ${Duration.between(start, end).toMillis()}millis")
}


suspend fun load(id: String): String {
    delay(1000)
    return "result$id"
}
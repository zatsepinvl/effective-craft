package com.effective.kotlin.hystrix

import com.netflix.hystrix.HystrixCommand
import com.netflix.hystrix.HystrixCommandGroupKey


fun main() {
    val command = CommandHelloWorld("test")
    val result = command.execute()
    print(result)
}

class CommandHelloWorld(private val name: String) : HystrixCommand<String>(HystrixCommandGroupKey.Factory.asKey("ExampleGroup")) {
    override fun run(): String {
        return "Hello $name!"
    }
}
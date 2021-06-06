package com.effective.kotlin.coroutines

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


@InternalCoroutinesApi
fun main(): Unit = runBlocking {
    fooFlow().collect {  }
}


fun fooFlow(): Flow<Int> = flow {
    emit(1)
}
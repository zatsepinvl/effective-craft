package com.effective.playground.spring.utils

import kotlin.reflect.KClass

val <T : Any> KClass<T>.name
    get() = simpleName!!
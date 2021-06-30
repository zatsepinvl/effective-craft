package com.effective.spring.mongodb

import org.springframework.context.annotation.Import
import org.springframework.test.context.TestPropertySource

@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@TestPropertySource(properties = ["test.datasource=mongodb-testcontainer"])
@Import(MongodbTestcontainerConfig::class)
annotation class EnableMongodbTestcontainer
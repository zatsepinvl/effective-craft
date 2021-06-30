package com.effective.spring.mongodb

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MongoDBContainer

private const val MONGODB_IMAGE = "mongo:4.4.4"

@ConditionalOnProperty(name = ["test.datasource"], havingValue = "mongodb-testcontainer")
@TestConfiguration
class MongodbTestcontainerConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun mongodbContainer(): MongoDBContainer {
        return MongoDBContainer(MONGODB_IMAGE)
    }

    @Bean
    fun mongoClient(mongoContainer: MongoDBContainer): MongoClient? {
        val connectionString = ConnectionString(mongoContainer.replicaSetUrl)
        val mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build()
        return MongoClients.create(mongoClientSettings)
    }
}
package com.effective.spring.mongodb

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.context.annotation.Import
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import java.util.concurrent.Executors
import java.util.concurrent.Phaser

@DataMongoTest
@EnableMongodbTestcontainer
class MongoPlaygroundTest {

    @Autowired
    lateinit var mongoTemplate: MongoTemplate

    @Autowired
    lateinit var repository: DataRepository

    @Test
    fun simple_data_access() {
        val result = repository.save(Data("id", 1))
        assert(result.id == "id")
    }

    @Test
    fun check_atomic_write() {
        repository.save(Data("d1", 0));

        val executor = Executors.newFixedThreadPool(2);
        val phaser = Phaser(2)
        val task = {
            println("task")
            val query = Query()
            query.addCriteria(Criteria.where("id").`is`("d1"))
            val update = Update()
            update["value"] = "Nick"
            update.set("value", "\$value + 1")
            phaser.arriveAndAwaitAdvance()
            val response = mongoTemplate.findAndModify(query, update, Data::class.java)
            println(response)
        }

        executor.submit({ task() })
        executor.submit({ task() })
        executor.submit({ task() })
    }
}


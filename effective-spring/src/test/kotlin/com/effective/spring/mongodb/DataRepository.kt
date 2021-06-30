package com.effective.spring.mongodb

import org.springframework.data.mongodb.repository.MongoRepository

interface DataRepository : MongoRepository<Data, String>
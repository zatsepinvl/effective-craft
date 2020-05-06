package com.effective.kotlin.elasticsearch

import org.apache.http.HttpHost
import org.elasticsearch.action.update.UpdateRequest
import org.elasticsearch.client.RestClient
import org.elasticsearch.client.RestHighLevelClient
import org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder


fun main() {
    val client = RestHighLevelClient(
            RestClient.builder(HttpHost("localhost", 9200, "http"))
    )

    val updateRequest = UpdateRequest()
    updateRequest.index("index")
    updateRequest.id("1")
    updateRequest.doc()
    client.update(updateRequest).get()
    client.close()
}

data class SourceCodeFile(
     val fileName:String,
     val language: String,
     val content: String
)
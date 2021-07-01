package com.effective.spring

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody

@Controller
class ControllerLargeFile {

    data class HttpErrorResponse(val message: String) {

    }

    @PostMapping("/data/csv/file/error")
    fun getLargeFileError(): ResponseEntity<Any> {
        return ResponseEntity.badRequest()
            .body(HttpErrorResponse("some error"))
    }

    @PostMapping("/data/csv/file")
    fun postLargeFile(): ResponseEntity<StreamingResponseBody> {
        val body = StreamingResponseBody { outputStream ->
            val mapper: ObjectMapper = CsvMapper()
            val schema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("event")
                .addColumn("payload")
                .setUseHeader(true)
                .build()
            val writer = mapper.writerFor(CsvDataItem::class.java).with(schema)
            makeManyObjects().forEach { item ->
                val bytes = writer.writeValueAsBytes(item)
                outputStream.write(bytes)
            }
        }
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=test.csv")
            .header(HttpHeaders.CONTENT_TYPE, "text/csv")
            .body(body)
    }

    @GetMapping("/data/csv/file")
    fun getLargeFile(): ResponseEntity<StreamingResponseBody> {
        val body = StreamingResponseBody { outputStream ->
            val mapper: ObjectMapper = CsvMapper()
            val schema = CsvSchema.builder()
                .addColumn("id")
                .addColumn("event")
                .addColumn("payload")
                .setUseHeader(true)
                .build()
            val writer = mapper.writerFor(CsvDataItem::class.java).with(schema)
            makeManyObjects().forEach { item ->
                val bytes = writer.writeValueAsBytes(item)
                outputStream.write(bytes)
            }
        }
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=test.csv")
            .body(body)
    }


    private fun makeManyObjects(): Sequence<CsvDataItem> {
        return IntRange(1, 10000000).asSequence()
            .map {
                CsvDataItem(
                    it.toString(), "Event #$it", "Payload for event #$it"
                )
            }
    }

}

data class CsvDataItem(
    val id: String,
    val event: String,
    val payload: String
)
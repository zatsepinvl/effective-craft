package com.effective.kotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.*
import java.net.ServerSocket

const val RESPONSE_BODY = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kotlin HTTP Server</title>
</head>
<body>
<center>
    <h1>Kotlin server is working!</h1>
</center>
</body>
</html>
"""

fun main() {
    val portNumber = 8080
    val socket = ServerSocket(portNumber)
    while (true) {
        val clientSocket = socket.accept()
        GlobalScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val input = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
                    val output = BufferedWriter(OutputStreamWriter(clientSocket.getOutputStream()))
                    var request: String
                    while (input.readLine().also { request = it } != null) {
                        if (request.isEmpty()) {
                            break
                        }
                    }
                    val response = String.format(
                        "HTTP/1.1 200 OK\r\nContent-Length: %d\r\n\r\n%s",
                        RESPONSE_BODY.length, RESPONSE_BODY
                    )
                    output.write(response)
                    output.close()
                    input.close()
                    clientSocket.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
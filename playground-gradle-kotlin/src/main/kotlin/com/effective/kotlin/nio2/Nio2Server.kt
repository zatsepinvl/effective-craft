package com.effective.kotlin.nio2

import org.apache.http.ProtocolVersion
import org.apache.http.message.BasicHttpResponse
import org.apache.http.message.BasicStatusLine
import java.io.IOException
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousServerSocketChannel
import java.nio.channels.AsynchronousSocketChannel
import java.nio.channels.CompletionHandler
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException


fun main() {
    val serverSocketChannel = AsynchronousServerSocketChannel.open().bind(
            InetSocketAddress(5000)
    )

    serverSocketChannel.accept<Nothing>(null, object : CompletionHandler<AsynchronousSocketChannel, Nothing> {
        override fun completed(channel: AsynchronousSocketChannel, attachment: Nothing?) {
            println("completed")
            // Accept the next connection

            // Accept the next connection
            serverSocketChannel.accept<Nothing>(null, this)

            // Greet the client

            val response = BasicHttpResponse(
                    BasicStatusLine(
                            ProtocolVersion("HTTP", 1, 1),
                            200,
                            "OK"
                    )
            )
            // Greet the client
            channel.write(ByteBuffer.wrap(response.toString().toByteArray()))

            // Allocate a byte buffer (4K) to read from the client

            // Allocate a byte buffer (4K) to read from the client
            val byteBuffer: ByteBuffer = ByteBuffer.allocate(4096)
            try {
                // Read the first line
                var bytesRead: Int = channel.read(byteBuffer).get(120, TimeUnit.SECONDS)
                var running = true
                while (bytesRead != -1 && running) {
                    println("bytes read: $bytesRead")

                    // Make sure that we have data to read
                    if (byteBuffer.position() > 2) {
                        // Make the buffer ready to read
                        byteBuffer.flip()

                        // Convert the buffer into a line
                        val lineBytes = ByteArray(bytesRead)
                        byteBuffer.get(lineBytes, 0, bytesRead)
                        val line = String(lineBytes)

                        // Debug
                        println("Message: $line")

                        // Echo back to the caller
                        channel.write(ByteBuffer.wrap(line.toByteArray()))

                        // Make the buffer ready to write
                        byteBuffer.clear()

                        // Read the next line
                        bytesRead = channel.read(byteBuffer).get(120, TimeUnit.SECONDS)
                    } else {
                        // An empty line signifies the end of the conversation in our protocol
                        running = false
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } catch (e: TimeoutException) {
                // The user exceeded the 120 second timeout, so close the connection
                channel.write(ByteBuffer.wrap("Good Bye\n".toByteArray()))
                println("Connection timed out, closing connection")
            }

            println("End of conversation")
            try {
                // Close the connection if we need to
                if (channel.isOpen()) {
                    channel.close()
                }
            } catch (e1: IOException) {
                e1.printStackTrace()
            }
        }

        override fun failed(exc: Throwable?, attachment: Nothing?) {
            println("failed")
        }
    })

    Thread.sleep(1000000000000000000)
}
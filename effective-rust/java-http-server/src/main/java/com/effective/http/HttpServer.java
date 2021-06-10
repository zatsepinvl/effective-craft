package com.effective.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class HttpServer {
    private static String body;

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = new ServerSocket(port);
        Executor executor = Executors.newFixedThreadPool(4);
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            executor.execute(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String request;
                    while ((request = in.readLine()) != null) {
                        if (request.isEmpty()) {
                            break;
                        }
                    }
                    if (body == null) {
                        InputStream bodyInputStream = HttpServer.class.getResourceAsStream("/index.html");
                        body = new BufferedReader(new InputStreamReader(bodyInputStream))
                                .lines().collect(Collectors.joining("\n"));
                    }
                    String response = String.format(
                            "HTTP/1.1 200 OK\r\nContent-Length: %d\r\n\r\n%s",
                            body.length(), body
                    );
                    out.write(response);
                    out.close();
                    in.close();
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}

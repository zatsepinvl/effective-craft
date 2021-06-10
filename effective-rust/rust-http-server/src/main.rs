#[allow(dead_code)]
use std::io::prelude::*;
use std::net::{TcpListener, TcpStream};
use std::io::Read;
use std::{fs, thread};
use threadpool::ThreadPool;
use std::ptr::null;
use std::sync::Arc;

fn main() -> std::io::Result<()> {
    let listener = TcpListener::bind("127.0.0.1:8080")?;
    let pool = ThreadPool::new(4);

    // accept connections and process them serially
    for stream in listener.incoming() {
        //single-threaded
        //handle_connection(stream.unwrap());

        //multi-threaded
        //thread::spawn(|| handle_connection(stream.unwrap()));

        //multi-threaded tuned
        pool.execute(|| handle_connection(stream.unwrap()).unwrap());
    }
    Ok(())
}

fn handle_connection(mut stream: TcpStream) -> std::io::Result<()> {
    let mut buffer = [0; 1024];
    stream.read(&mut buffer).unwrap();
    //println!("Request: {}", String::from_utf8_lossy(&buffer[..]));
    let  index_html = String::from(
        r#"<!DOCTYPE html><html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Rust HTTP Server</title>
            </head>
            <body>
            <center>
                <h1>Rust server is working!</h1>
            </center>
            </body>
            </html>"#);

    let response = format!(
        "HTTP/1.1 200 OK\r\nContent-Length: {}\r\n\r\n{}",
        index_html.len(),
        index_html
    );
    stream.write(response.as_bytes()).unwrap();
    stream.flush()
}



use actix_web::{get, post, web, App, HttpResponse, HttpServer, Responder};

mod blockchain;

use blockchain::BlockChain;
use blockchain::Transaction;

#[get("/")]
async fn hello() -> impl Responder {
    HttpResponse::Ok().body("Hello world!")
}

#[post("/echo")]
async fn echo(req_body: String) -> impl Responder {
    HttpResponse::Ok().body(req_body)
}

async fn manual_hello() -> impl Responder {
    HttpResponse::Ok().body("Hey there!")
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| {
        App::new()
            .service(hello)
            .service(echo)
            .route("/hey", web::get().to(manual_hello))
    })
        .bind("127.0.0.1:8080")?
        .run()
        .await
}

fn blockchain_test() {
    let genesis_block = BlockChain::generate_genesis_block();
    let blockchain = &mut BlockChain::new(genesis_block);

    blockchain.send_transaction(Transaction { payload: "payload".to_string() });
    blockchain.mine();

    println!("{:?}", blockchain);
}


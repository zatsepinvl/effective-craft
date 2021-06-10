use std::collections::hash_map::DefaultHasher;
use std::hash::{Hash, Hasher};
use chrono::prelude::*;

#[derive(Debug, Clone, Hash)]
pub struct Transaction {
    pub payload: String
}


#[derive(Debug, Clone)]
pub struct Block {
    pub index: u64,
    pub timestamp: i64,
    pub hash: u64,
    pub prev_block_hash: u64,
    pub transactions: Vec<Transaction>,
}

#[derive(Debug)]
pub struct BlockChainError {
    pub message: String
}

#[derive(Debug)]
pub struct BlockChain {
    pub chain: Vec<Block>,
    pub pending_transactions: Vec<Transaction>,
}

impl BlockChain {
    pub fn generate_genesis_block() -> Block {
        let utc: DateTime<Utc> = Utc::now();
        return Block {
            index: 0,
            timestamp: utc.timestamp(),
            hash: 0,
            transactions: vec![],
            prev_block_hash: 0,
        };
    }

    pub fn new(genesis_block: Block) -> BlockChain {
        BlockChain {
            chain: vec![genesis_block],
            pending_transactions: vec![],
        }
    }

    pub fn get_last_block(&self) -> Block {
        let block_optional = self.chain.last();
        block_optional.unwrap().clone()
    }

    pub fn send_transaction(&mut self, transaction: Transaction) {
        self.pending_transactions.push(transaction)
    }

    //Mine new block with all pending transactions in it
    pub fn mine(&mut self) -> Block {
        let prev_block = self.get_last_block();
        let transactions = &mut vec![];
        for transaction in self.pending_transactions.drain(..) {
            transactions.push(transaction)
        }
        let new_block = self.generate_block(prev_block.index + 1, prev_block.hash, transactions.to_owned());
        self.add_block(new_block.clone());
        new_block
    }

    //private
    fn generate_block(&self, index: u64, prev_block_hash: u64, transactions: Vec<Transaction>) -> Block {
        let utc: DateTime<Utc> = Utc::now();
        let timestamp = utc.timestamp();
        let mut hasher = DefaultHasher::new();
        index.hash(&mut hasher);
        timestamp.hash(&mut hasher);
        transactions.iter().for_each(|tr| tr.hash(&mut hasher));
        prev_block_hash.hash(&mut hasher);
        let hash = hasher.finish();
        return Block {
            index,
            timestamp,
            hash,
            transactions,
            prev_block_hash: 0,
        };
    }

    //private
    fn add_block(&mut self, new_block: Block) {
        let last_block = self.get_last_block();
        if new_block.prev_block_hash == last_block.hash {
            self.chain.push(new_block);
        } else {
            panic!("Block should refer to the latest block in the chain")
        }
    }
}
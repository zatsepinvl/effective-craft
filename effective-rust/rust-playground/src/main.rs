mod restaurant;

use restaurant::back_of_house::cook;
use restaurant::serve;
use std::borrow::BorrowMut;

fn main() {
    test_access();
}

fn access(boxx: &mut Box<Vec<i32>>) -> &mut Vec<i32>  {
   boxx.borrow_mut()
}

pub fn test_access() {
    let vec = {
        let vecc = vec![1];
        let boxx = &mut Box::new(vecc);
        let another = access(boxx);
    };
    //println!("{:?}", vec);
}
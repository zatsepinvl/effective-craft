package com.effective.kotlin.gcp

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.*
import com.google.firebase.auth.UserRecord

fun main() {
    var auth = getInstance()
    val userRecord: UserRecord = auth.getUser("test");
}
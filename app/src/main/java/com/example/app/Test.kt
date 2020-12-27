package com.example.app

import com.example.app.entity.User

var user= User("AA","BB","CC")
val userCopy= user.copy()

fun main(){
    print(user)
    print(userCopy)
}
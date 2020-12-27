package com.example.core

import android.app.Application
import android.content.Context

class BaseApplication:Application() {

    companion object{
         lateinit var currentApplication:Context
            private set

//        fun currentApplication():Context{
//            return currentApplication
//        }
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication=this
    }
}
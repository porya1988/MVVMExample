package com.example.kotlintraining.config

import android.app.Application

class AppConfiguration : Application() {

    companion object{
        var instance: AppConfiguration? =null
    }


    override fun onCreate() {
        super.onCreate()
        instance=this
    }


   fun getInstance(): AppConfiguration? {
       return instance
   }
}
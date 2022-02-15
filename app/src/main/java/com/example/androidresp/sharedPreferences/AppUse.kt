package com.example.androidresp.sharedPreferences

import android.app.Application
import android.content.Context
import com.example.androidresp.sqlite.MyDataBase

class AppUse: Application() {
    companion object{
        val BASE="baseJuegos"
        val TABLA = "tablaJuegos"
        val VERSION = 1
        lateinit var appContext : Context
        lateinit var DB: MyDataBase
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        DB = MyDataBase()
    }
}
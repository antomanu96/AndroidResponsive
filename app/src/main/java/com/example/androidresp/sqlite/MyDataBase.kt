package com.example.androidresp.sqlite

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.androidresp.sharedPreferences.AppUse

class MyDataBase:SQLiteOpenHelper(AppUse.appContext, AppUse.BASE, null, AppUse.VERSION) {

    var time = System.currentTimeMillis()

    val consultaCrear="CREATE TABLE ${AppUse.TABLA}("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "nombre TEXT NOT NULL, "+
            "descripcion TEXT NOT NULL, "+
            "categoria TEXT NOT NULL, "+
            "fecha INT NOT NULL, "+
            "image TEXT DEFAULT '');"

    val crearDatos1 = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha, image) " +
            "VALUES ('God of War','Kratos mata cosas' ,'accion', ${time},'android.resource://com.example.androidresp/drawable/godofwar' );"
    val crearDatos2 = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha, image ) " +
            "VALUES ('Danganronpa','Cluedo pero con adolescentes' ,'Misterio', ${time}, 'android.resource://com.example.androidresp/drawable/danganronpa' );"
    val crearDatos3 = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha, image ) " +
            "VALUES ('League of Legends','Porque te quieres tan poco' ,'Sal', ${time}, 'android.resource://com.example.androidresp/drawable/lol');"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(consultaCrear)
        p0?.execSQL(crearDatos1)
        p0?.execSQL(crearDatos2)
        p0?.execSQL(crearDatos3)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val borrar = "DROP TABLE IF EXISTS " + AppUse.TABLA
        p0?.execSQL(borrar)
        onCreate(p0)
    }

}
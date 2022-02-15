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
            "image INT DEFAULT 0);"

    val crearDatos1 = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha) " +
            "VALUES ('God of War','Kratos mata cosas' ,'accion', ${time});"
    val crearDatos2 = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha) " +
            "VALUES ('Danganronpa','Cluedo pero con adolescentes' ,'Misterio', ${time});"
    val crearDatos3 = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha) " +
            "VALUES ('League of Legends','Porque te quieres tan poco' ,'Sal', ${time});"

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
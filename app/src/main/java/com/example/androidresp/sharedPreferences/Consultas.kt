package com.example.androidresp.sharedPreferences

import android.database.DatabaseUtils
import android.util.Log
import com.example.androidresp.recyclerVideoJuegos.VideoJuegos
import java.lang.Exception

class Consultas {
    var time = System.currentTimeMillis()
    fun create(videojuego: VideoJuegosRegistro){
        val crearConsulta = "INSERT INTO" + AppUse.TABLA + "(nombre, descripcion, categoria, fecha, image) VALUES (${videojuego.nombre},${videojuego.descripcion},${videojuego.categoria},${time},${videojuego.image})"
        val conexion = AppUse.DB.writableDatabase
        try{
            conexion.execSQL(crearConsulta)
            conexion.close()
        }catch (ex: Exception){
            Log.d("Error al insertar datos: ", ex.message.toString())
        }
    }

    fun read(): MutableList<VideoJuegos>{
        val lista = mutableListOf<VideoJuegos>()
        val consultaRead = "SELECT * FROM " + AppUse.TABLA
        val conexion = AppUse.DB.readableDatabase
        val consultaTotal = DatabaseUtils.queryNumEntries(conexion, AppUse.TABLA)
        return lista
    }
}
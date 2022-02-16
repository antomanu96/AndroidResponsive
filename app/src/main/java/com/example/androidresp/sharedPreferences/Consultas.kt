package com.example.androidresp.sharedPreferences

import android.database.DatabaseUtils
import android.util.Log
import com.example.androidresp.recyclerVideoJuegos.VideoJuegos
import java.lang.Exception

class Consultas {
    var time = System.currentTimeMillis()
    fun create(videojuego: VideoJuegosRegistro){
        val crearConsulta = "INSERT INTO " + AppUse.TABLA + " (nombre, descripcion, categoria, fecha, image) VALUES ('${videojuego.nombre}','${videojuego.descripcion}','${videojuego.categoria}',${time},'${videojuego.image}')"
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
        if(consultaTotal > 0){
            try{
                val pivot = conexion.rawQuery(consultaRead, null)
                while(pivot.moveToNext()){
                    var item = VideoJuegos(pivot.getInt(0), pivot.getString(1), pivot.getString(2), pivot.getString(3), pivot.getInt(4), pivot.getString(5))
                    lista.add(item)
                }
            }catch (ex: Exception){
                Log.d("Error al leer los juegos: ", ex.message.toString())
            }
        }
        return lista
    }

    fun devolverUltimos(): MutableList<VideoJuegos>{
        val lista = mutableListOf<VideoJuegos>()
        val consultaRead = "SELECT * FROM ${AppUse.TABLA} ORDER BY fecha DESC LIMIT 3";
        val conexion = AppUse.DB.readableDatabase
        val consultaTotal = DatabaseUtils.queryNumEntries(conexion, AppUse.TABLA)
        if(consultaTotal > 0){
            try{
                val pivot = conexion.rawQuery(consultaRead, null)
                while(pivot.moveToNext()){
                    var item = VideoJuegos(pivot.getInt(0), pivot.getString(1), pivot.getString(2), pivot.getString(3), pivot.getInt(4), pivot.getString(5))
                    lista.add(item)
                }
            }catch (ex: Exception){
                Log.d("Error al leer los juegos: ", ex.message.toString())
            }
        }
        return lista
    }
}
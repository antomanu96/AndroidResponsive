package com.example.androidresp.sharedPreferences

import com.example.androidresp.recyclerVideoJuegos.VideoJuegos

class Consultas {
    var time = System.currentTimeMillis()
    fun create(videojuego: VideoJuegosRegistro){
        val crearConsulta = "INSERT INTO" + AppUse.TABLA + "(nombre, descripcion, categoria, fecha, image) VALUES (${videojuego.nombre},${videojuego.descripcion},${videojuego.categoria},${time},${videojuego.image})"
    }
}
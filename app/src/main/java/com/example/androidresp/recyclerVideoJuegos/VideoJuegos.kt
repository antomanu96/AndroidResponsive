package com.example.androidresp.recyclerVideoJuegos
import android.net.Uri

data class VideoJuegos(
    val id:Int,
    val nombre:String,
    val descripcion:String,
    val categoria:String,
    val fecha:Int,
    val image:Uri
)

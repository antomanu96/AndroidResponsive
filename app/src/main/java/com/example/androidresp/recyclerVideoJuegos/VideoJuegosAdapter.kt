package com.example.androidresp.recyclerVideoJuegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidresp.R
import com.example.androidresp.databinding.ActivityReadBinding
import com.example.androidresp.databinding.VideojuegosLayoutBinding


class VideoJuegosAdapter(private val list:MutableList<VideoJuegos>):RecyclerView.Adapter<VideoJuegosAdapter.VideoJuegosHolder>(){

    class VideoJuegosHolder(v: View):RecyclerView.ViewHolder(v) {
       val binding = VideojuegosLayoutBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoJuegosHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.videojuegos_layout,parent,false)
        return VideoJuegosHolder(v)
    }

    override fun onBindViewHolder(holder: VideoJuegosHolder, position: Int) {
        val juego = list[position]
        holder.binding.tvNombreR.text = juego.nombre
        holder.binding.tvCategoriaR.text = juego.categoria
        holder.binding.tvDescripcR.text = juego.descripcion
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}
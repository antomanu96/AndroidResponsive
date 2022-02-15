package com.example.androidresp.reyclerVideoJuegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidresp.R
import com.example.androidresp.databinding.ActivityReadBinding


class VideoJuegosAdapter(private val list:MutableList<VideoJuegos>):RecyclerView.Adapter<VideoJuegosAdapter.VideoJuegosHolder>(){

    class VideoJuegosHolder(v: View):RecyclerView.ViewHolder(v) {
       val binding =ActivityReadBinding.bind(v)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoJuegosHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(R.layout.activity_read,parent,false)
        return VideoJuegosHolder(v)
    }

    override fun onBindViewHolder(holder: VideoJuegosHolder, position: Int) {
        val juego = list[position]
    }

    override fun getItemCount(): Int {
        return list.count()
    }
}
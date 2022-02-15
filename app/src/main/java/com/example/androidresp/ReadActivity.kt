package com.example.androidresp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidresp.databinding.ActivityReadBinding
import com.example.androidresp.recyclerVideoJuegos.VideoJuegos
import com.example.androidresp.recyclerVideoJuegos.VideoJuegosAdapter
import com.example.androidresp.sharedPreferences.Consultas

class ReadActivity : AppCompatActivity() {
    lateinit var binding: ActivityReadBinding
    lateinit var adapter: VideoJuegosAdapter
    lateinit var listaVideojuegos: MutableList<VideoJuegos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecycler()
    }

    private fun getDatos(){
        val leer = Consultas().read()
        listaVideojuegos = leer
    }

    private fun setRecycler(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        getDatos()
        adapter = VideoJuegosAdapter(listaVideojuegos)
        binding.recyclerView.adapter = adapter
    }

}
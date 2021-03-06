package com.example.androidresp


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidresp.databinding.ActivityMainBinding
import com.example.androidresp.recyclerVideoJuegos.VideoJuegos
import com.example.androidresp.sharedPreferences.Consultas
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso

class MainActivity : PantallaCompleta() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        ultimosDatos()
    }

    override fun onResume() {
        ultimosDatos()
        super.onResume()
    }

    private fun ultimosDatos(){
        val leerDatos: MutableList<VideoJuegos> = Consultas().devolverUltimos()
        binding.tvNombre1.setText(leerDatos[0].nombre)
        binding.tvCategoria1.setText(leerDatos[0].categoria)
        binding.tvDescrip1.setText(leerDatos[0].descripcion)
        Picasso.get().load(Uri.parse(leerDatos[0].image)).into(binding.imageView2)


        binding.tvNombre2.setText(leerDatos[1].nombre)
        binding.tvCategoria2.setText(leerDatos[1].categoria)
        binding.tvDescrip2.setText(leerDatos[1].descripcion)
        Picasso.get().load(Uri.parse(leerDatos[1].image)).into(binding.imageView3)

        binding.tvNombre3.setText(leerDatos[2].nombre)
        binding.tvCategoria3.setText(leerDatos[2].categoria)
        binding.tvDescrip3.setText(leerDatos[2].descripcion)
        Picasso.get().load(Uri.parse(leerDatos[2].image)).into(binding.imageView4)

    }

    private fun setListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.btnCrear -> {
                    startActivity(Intent(this,CreateActivity::class.java))
                    true
                }
                R.id.btnVer -> {
                    startActivity(Intent(this,ReadActivity::class.java))
                    true
                }
                R.id.btnSalir -> {
                    salir()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun salir() {
        finishAffinity()
        System.exit(0)
    }
}
package com.example.androidresp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidresp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }

    private fun setListener() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.btnCrear -> {
                    Log.d("BOTON1------->", "PULSADO")
                    true
                }
                R.id.btnVer -> {
                    Log.d("BOTON2------->", "PULSADO")
                    true
                }
                R.id.btnSalir -> {
                    Log.d("BOTON3------->", "PULSADO")
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
package com.example.androidresp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidresp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : PantallaCompleta() {
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
package com.example.androidresp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.androidresp.databinding.ActivityCreateBinding
import com.example.androidresp.recyclerVideoJuegos.VideoJuegos
import com.example.androidresp.sharedPreferences.Consultas
import com.example.androidresp.sharedPreferences.VideoJuegosRegistro
import com.squareup.picasso.Picasso

class CreateActivity : PantallaCompleta() {

    var responseImg = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                if(it.data != null){
                    uri = it.data!!.data
                    cargarFoto()
                }
            }
    }

    lateinit var binding:ActivityCreateBinding
    private var uri: Uri? = null
    var nombre:String = ""
    var category:String = ""
    var descp:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {

        binding.btnSubirFoto.setOnClickListener {
            cambiarFoto()
        }

        binding.btnCrear.setOnClickListener {
            if(comprobarCampos()){
                Consultas().create(VideoJuegosRegistro(nombre,category,descp,uri.toString()))
            }
        }

    }

    private fun comprobarCampos(): Boolean {
        nombre = binding.txtNombreCrear.text.toString()
        category = binding.txtCategCrear.text.toString()
        descp = binding.txtDescCrear.text.toString()

        if(nombre.isEmpty() || category.isEmpty() || descp.isEmpty()) return false

        return true

    }

    private fun cargarFoto() {
        if(uri!=null)
            Picasso.get().load(uri).resize(200, 200).centerCrop().into(binding.imageView7)
        else
            Toast.makeText(this,"Error al cargar la imagen", Toast.LENGTH_LONG).show()
    }

    private fun cambiarFoto() {

            val i = Intent(Intent.ACTION_OPEN_DOCUMENT)
            i.addCategory(Intent.CATEGORY_OPENABLE)
            i.setType("image/*")

            responseImg.launch(i)


    }

}
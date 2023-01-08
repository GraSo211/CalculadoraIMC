package com.grasocorp.calculadoraimc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.grasocorp.calculadoraimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalc.setOnClickListener{
            enviarDatos()
        }
    }

    fun enviarDatos(){
        if (binding.etAlt.text.isNotEmpty() && binding.etPeso.text.isNotEmpty()){
            val conexion: Intent = Intent(this, calcularIMC_activity:: class.java)
            conexion.putExtra("peso",binding.etPeso.text)
            conexion.putExtra("altura",binding.etAlt.text)
            startActivity(conexion)
        }else{
            Toast.makeText(this, "Alguno de los campos estan vacios.", Toast.LENGTH_SHORT).show()
        }
    }
}
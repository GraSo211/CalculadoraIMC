package com.grasocorp.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grasocorp.calculadoraimc.databinding.ActivityCalcularImcBinding
import kotlin.math.ceil
import kotlin.math.roundToInt

class calcularIMC_activity : AppCompatActivity() {
    private lateinit var binding: ActivityCalcularImcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcularImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnVolver.setOnClickListener{
            onBackPressed()
        }
        val valor = calcularImc()
        medidasImc(valor)
    }
        fun calcularImc(): Float {
            val datos = intent.extras
            val peso = (datos?.get("peso")).toString().toFloat()
            val alt = (datos?.get("altura")).toString().toFloat()
            var imc = ceil(peso / (alt * alt))
            binding.tvImc.text = "El IMC es: $imc"
            return imc
        }

        fun medidasImc(valor:Float){
            var medida = ""
            if (valor < 18.5){
                medida = "Estas Flaco"
            }else if ( valor >= 18.5 && valor <= 24.9){
                medida = "Estas Bien"
            }else if ( valor >= 25 && valor <= 29.9) {
                medida = "Estas Gordito"

            }else if ( valor >= 30 && valor <= 34.9){
                medida= "Estas Gordo"
            }else if ( valor >= 35 && valor <= 39.9) {
                medida = "Estas Gordaso"
            }else if ( valor >= 40) {
                medida = "Estas Obeso"
            }
            binding.tvMedidas.text = medida
            print("LLegue hasta aca")
            }

        }

package com.example.tarefa2

import android.os.Bundle
import android.widget.ArrayAdapter

import androidx.appcompat.app.AppCompatActivity

import com.example.tarefa2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val opcoesSexo = listOf("Feminino", "Masculino")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcoesSexo)

        // Adicione esta linha para definir o layout do dropdown
        binding.spinner.adapter = adapter


        binding.botao.setOnClickListener {
            val sexoSelecionado = binding.spinner.selectedItem as String
            val idade = binding.input.text.toString().toLongOrNull()
            var textResultado : String
            var resultado : Long

            if (idade != null) {
                if (sexoSelecionado.trim() == "Masculino") {
                    resultado = 65 - idade
                    if (idade < 65 ){
                        textResultado = "Faltam ${resultado} ano(s) para você se aposentar"
                    }else{
                        textResultado = "Você já está aposentado há ${resultado* -1} ano(s)!"
                    }


                } else {
                    resultado = 62 - idade
                        if (idade < 62) {
                            textResultado = "Faltam ${resultado} ano(s) para você se aposentar"
                        } else {
                            textResultado = "Você já está aposentada há ${resultado * -1} ano(s)!"
                        }

                }
                binding.resultado.text = textResultado
            }else{
                binding.resultado.text = "Informe uma idade"
            }
        }

    }
}
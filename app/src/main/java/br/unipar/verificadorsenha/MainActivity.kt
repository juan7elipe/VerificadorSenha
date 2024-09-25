package br.unipar.verificadorsenha

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputSenha = findViewById<EditText>(R.id.edSenha)
        val botaoConfirmar = findViewById<Button>(R.id.btnVerificar)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val senha = 12345


        botaoConfirmar.setOnClickListener {
            val senhaInformada = inputSenha.text.toString()

            if (senhaInformada.isNotEmpty()) {
                val senhaInt = senhaInformada.toInt()

                if (senhaInt == senha) {
                    resultado.text = "As senhas conferem"

                } else {
                    resultado.text = "As senhas não conferem. Digite novamente."
                }
            }
        }
    }
    fun limparValores(view: View) {
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val input = findViewById<EditText>(R.id.edSenha)

        resultado.setText("")
        input.setText("")
    }
}
package br.com.doreadev.eletriccar.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.doreadev.eletriccar.R

class CalcularAutonomiaActivity : AppCompatActivity() {
    lateinit var precoKwh: EditText
    lateinit var kmPercorrido: EditText
    lateinit var resultado: TextView
    lateinit var btnCalcular: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calcular_autonomia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupView()
        setupListeners()
    }

    private fun setupListeners() {
        btnCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun setupView() {
        precoKwh = findViewById(R.id.et_precoKwhId)
        kmPercorrido = findViewById(R.id.et_kmPercorridoId)
        resultado = findViewById(R.id.tv_resultadoId)
        btnCalcular = findViewById(R.id.btn_calcularId)
    }

    private fun calcular() {
        val preco = precoKwh.text.toString().toFloat()
        val km = kmPercorrido.text.toString().toFloat()
        val result = preco / km
        resultado.text = result.toString()
    }
}
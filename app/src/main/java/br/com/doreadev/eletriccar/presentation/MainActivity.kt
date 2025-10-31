package br.com.doreadev.eletriccar.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.doreadev.eletriccar.R

class MainActivity : AppCompatActivity() {
    lateinit var imagemCarro: ImageView
    lateinit var precoValue: TextView
    lateinit var bateriaValue: TextView
    lateinit var potenciaValue: TextView
    lateinit var recargaValue: TextView
    lateinit var btnCalcularAutonomia: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        imagemCarro = findViewById(R.id.iv_carId)
        precoValue = findViewById(R.id.tv_precoValueId)
        bateriaValue = findViewById(R.id.tv_bateriaValueId)
        potenciaValue = findViewById(R.id.tv_potenciaValueId)
        recargaValue = findViewById(R.id.tv_recargaValueId)
        btnCalcularAutonomia = findViewById(R.id.btn_calcularAutonomiaId)
    }

    private fun setupListeners() {
        btnCalcularAutonomia.setOnClickListener {
            startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
        }

    }
}
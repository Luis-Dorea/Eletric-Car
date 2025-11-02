package br.com.doreadev.eletriccar.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.doreadev.eletriccar.R
import br.com.doreadev.eletriccar.data.CarFactory
import br.com.doreadev.eletriccar.ui.adapter.CarAdapter

class MainActivity : AppCompatActivity() {
    lateinit var btnCalcularAutonomia: Button
    lateinit var listaCarros: RecyclerView

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
        setupListView()
    }

    private fun setupViews() {
        btnCalcularAutonomia = findViewById(R.id.btn_calcularAutonomiaId)
        listaCarros = findViewById(R.id.rv_listaCarrosId)
    }

    private fun setupListeners() {
        btnCalcularAutonomia.setOnClickListener {
            startActivity(Intent(this, CalcularAutonomiaActivity::class.java))
        }

    }

    private fun setupListView() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }
}
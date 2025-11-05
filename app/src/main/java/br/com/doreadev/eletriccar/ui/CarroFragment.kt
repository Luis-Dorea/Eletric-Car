package br.com.doreadev.eletriccar.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import br.com.doreadev.eletriccar.R
import br.com.doreadev.eletriccar.data.CarFactory
import br.com.doreadev.eletriccar.ui.adapter.CarAdapter

class CarroFragment : Fragment() {
    lateinit var listaCarros: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carro, container, false)
    }

    //É melhor colocar nessa etapa do siclo de vida do fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        setupListView()
    }

    private fun setupView(view: View){
        view.apply {
            listaCarros = findViewById(R.id.rv_listaCarrosId)
        }
    }

    private fun setupListView() {
        val adapter = CarAdapter(CarFactory.list)
        listaCarros.adapter = adapter
    }
}
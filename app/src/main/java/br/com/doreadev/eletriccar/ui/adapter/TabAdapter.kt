package br.com.doreadev.eletriccar.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.doreadev.eletriccar.ui.CarroFragment
import br.com.doreadev.eletriccar.ui.FavoritosFragment

class TabAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CarroFragment()
            1 -> FavoritosFragment()
            else -> {
                CarroFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
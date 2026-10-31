package com.example.petagram

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PerfilFragment : Fragment(R.layout.fragment_perfil) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.rvFotos)
        rv.layoutManager = GridLayoutManager(requireContext(), 3) // Grid de 3 columnas
        rv.adapter = FotoAdapter(DatosDummy.fotosPerfil)
    }
}
package com.example.petagram

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MascotasFragment : Fragment(R.layout.fragment_mascotas) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv = view.findViewById<RecyclerView>(R.id.rvMascotas)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = MascotaAdapter(DatosDummy.mascotas)
    }
}
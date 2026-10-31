package com.example.petagram

import android.graphics.Color

object DatosDummy {

    private val rosa = Color.parseColor("#FF6B9D")
    private val azul = Color.parseColor("#1976D2")

    // DataSet de la lista principal
    val mascotas = listOf(
        Mascota("Catty", R.drawable.ic_mascota, rosa, 5),
        Mascota("Ronny", R.drawable.ic_mascota, azul, 3),
        Mascota("Luna", R.drawable.ic_mascota, rosa, 4),
        Mascota("Max", R.drawable.ic_mascota, azul, 2),
        Mascota("Toby", R.drawable.ic_mascota, rosa, 1),
        Mascota("Rocky", R.drawable.ic_mascota, azul, 0)
    )

    // DataSet de las fotos del perfil (Grid)
    val fotosPerfil = listOf(
        FotoMascota(R.drawable.ic_mascota, 5),
        FotoMascota(R.drawable.ic_mascota, 0),
        FotoMascota(R.drawable.ic_mascota, 3),
        FotoMascota(R.drawable.ic_mascota, 10),
        FotoMascota(R.drawable.ic_mascota, 2),
        FotoMascota(R.drawable.ic_mascota, 3),
        FotoMascota(R.drawable.ic_mascota, 1),
        FotoMascota(R.drawable.ic_mascota, 4),
        FotoMascota(R.drawable.ic_mascota, 6)
    )
}
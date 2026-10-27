package com.example.petagram

data class Mascota(
    val nombre: String,
    val foto: Int,
    val colorFondo: Int,
    var rating: Int = 0
)
package com.example.petagram

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritosActivity : AppCompatActivity() {

    private val rosa = Color.parseColor("#FF6B9D")
    private val azul = Color.parseColor("#1976D2")

    // 5 mascotas dummy (hardcodeadas)
    private val favoritas = listOf(
        Mascota("Ronny", R.drawable.ic_mascota, azul, 5),
        Mascota("Catty", R.drawable.ic_mascota, rosa, 4),
        Mascota("Luna", R.drawable.ic_mascota, rosa, 3),
        Mascota("Max", R.drawable.ic_mascota, azul, 3),
        Mascota("Toby", R.drawable.ic_mascota, rosa, 2)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbarFav))
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // botón para subir

        val rv = findViewById<RecyclerView>(R.id.rvFavoritos)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MascotaAdapter(favoritas, permitirLike = false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish() // regresa al Activity padre
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
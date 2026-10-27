package com.example.petagram

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rosa = Color.parseColor("#FF6B9D")
    private val azul = Color.parseColor("#1976D2")

    // DataSet
    private val mascotas = listOf(
        Mascota("Catty", R.drawable.ic_mascota, rosa, 5),
        Mascota("Ronny", R.drawable.ic_mascota, azul, 3),
        Mascota("Luna", R.drawable.ic_mascota, rosa, 4),
        Mascota("Max", R.drawable.ic_mascota, azul, 2),
        Mascota("Toby", R.drawable.ic_mascota, rosa, 1),
        Mascota("Rocky", R.drawable.ic_mascota, azul, 0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val rv = findViewById<RecyclerView>(R.id.rvMascotas)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = MascotaAdapter(mascotas)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favoritos) {
            startActivity(Intent(this, FavoritosActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.petagram

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = ViewPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(if (position == 0) R.drawable.ic_home else R.drawable.ic_perfil)
        }.attach()

        findViewById<FloatingActionButton>(R.id.fabCamara).setOnClickListener {
            Toast.makeText(this, "Cámara próximamente", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favoritos -> {
                startActivity(Intent(this, FavoritosActivity::class.java))
                true
            }
            R.id.action_contacto -> {
                startActivity(Intent(this, ContactoActivity::class.java))
                true
            }
            R.id.action_acerca -> {
                startActivity(Intent(this, AcercaDeActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
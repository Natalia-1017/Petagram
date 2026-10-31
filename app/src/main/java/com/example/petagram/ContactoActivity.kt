package com.example.petagram

import android.os.Bundle
import android.util.Patterns
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ContactoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        setSupportActionBar(findViewById<Toolbar>(R.id.toolbarContacto))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tilNombre = findViewById<TextInputLayout>(R.id.tilNombre)
        val tilCorreo = findViewById<TextInputLayout>(R.id.tilCorreo)
        val tilMensaje = findViewById<TextInputLayout>(R.id.tilMensaje)
        val etNombre = findViewById<TextInputEditText>(R.id.etNombre)
        val etCorreo = findViewById<TextInputEditText>(R.id.etCorreo)
        val etMensaje = findViewById<TextInputEditText>(R.id.etMensaje)
        val btnEnviar = findViewById<MaterialButton>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val mensaje = etMensaje.text.toString().trim()

            tilNombre.error = if (nombre.isEmpty()) "Ingresa tu nombre" else null
            tilCorreo.error =
                if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) "Correo no válido" else null
            tilMensaje.error = if (mensaje.isEmpty()) "Escribe tu mensaje" else null

            if (listOf(tilNombre, tilCorreo, tilMensaje).any { it.error != null }) {
                return@setOnClickListener
            }

            btnEnviar.isEnabled = false
            btnEnviar.text = "Enviando..."

            Thread {
                try {
                    MailSender.enviar(nombre, correo, mensaje)
                    runOnUiThread {
                        Toast.makeText(this, "Comentario enviado", Toast.LENGTH_LONG).show()
                        etNombre.setText("")
                        etCorreo.setText("")
                        etMensaje.setText("")
                    }
                } catch (e: Exception) {
                    runOnUiThread {
                        Toast.makeText(this, "No se pudo enviar: ${e.message}", Toast.LENGTH_LONG).show()
                    }
                } finally {
                    runOnUiThread {
                        btnEnviar.isEnabled = true
                        btnEnviar.text = "Enviar comentario"
                    }
                }
            }.start()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
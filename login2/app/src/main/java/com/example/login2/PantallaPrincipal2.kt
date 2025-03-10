package com.example.login2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class PantallaPrincipal2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal2)

        val textV = findViewById<TextView>(R.id.bienvenida)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val correo = intent.getStringExtra("email") ?: "Usuario"
        textV.text = "Bienvenido, $correo"

        btnLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

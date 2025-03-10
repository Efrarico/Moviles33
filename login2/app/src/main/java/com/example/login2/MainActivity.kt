package com.example.login2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: AppCompatEditText
    private lateinit var psw: AppCompatEditText
    private lateinit var btnLogin:AppCompatButton
    private lateinit var btnRegister:AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            v.setPadding(
                insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom
            )
            insets
        }

        auth = FirebaseAuth.getInstance()
        user = findViewById(R.id.usuario)
        psw = findViewById(R.id.contrasena)
        btnLogin = findViewById(R.id.inicio)
        btnRegister = findViewById(R.id.registro)

        btnLogin.setOnClickListener(View.OnClickListener { v: View? ->
            val correo = user.getText().toString().trim { it <= ' ' }
            val contra = psw.getText().toString().trim { it <= ' ' }
            if (!correo.isEmpty() && !contra.isEmpty()) {
                login(correo, contra)
            } else {
                Toast.makeText(this, "Ingresa las credenciales", Toast.LENGTH_SHORT).show()
            }
        })

        btnRegister.setOnClickListener(View.OnClickListener { v: View? ->
            val correo = user.getText().toString().trim { it <= ' ' }
            val contra = psw.getText().toString().trim { it <= ' ' }
            if (!correo.isEmpty() && !contra.isEmpty()) {
                registrar(correo, contra)
            } else {
                Toast.makeText(this, "Ingresa las credenciales", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun login(correo: String, contra: String) {
        auth.signInWithEmailAndPassword(correo, contra)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()
                    val intento = Intent(this, PantallaPrincipal2::class.java)
                    intento.putExtra("email", correo) // Cambié la clave a "email"
                    startActivity(intento)
                    finish() // Cierra la pantalla de login
                } else {
                    Toast.makeText(
                        this,
                        "Error: " + task.exception?.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    private fun registrar(correo: String, contra: String) {
        auth!!.createUserWithEmailAndPassword(correo, contra)
            .addOnCompleteListener(
                this
            ) { task: Task<AuthResult?> ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this,
                        "Error: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}
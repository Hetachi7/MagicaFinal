package com.example.magica_colombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FirebaseApp.initializeApp(this)
        val logintbtn2 = findViewById<Button>(R.id.login2)
        logintbtn2.setOnClickListener(viewListener)

        val usernameEditText: EditText = findViewById(R.id.username)
        val passwordEditText: EditText = findViewById(R.id.password)

        val loginButton: Button = findViewById(R.id.login2)
    }

    fun enviarhome() {
        val intent: Intent = Intent(this, Home::class.java)
        startActivity(intent)
    }

    fun enviarRecuperar() {
        val intent: Intent = Intent(this, Recuperar::class.java)
        startActivity(intent)
    }

    fun enviarSing_in() {
        val intent: Intent = Intent(this, Sing_in::class.java)
        startActivity(intent)
    }


    private val viewListener = View.OnClickListener {
        when (it.id) {
            R.id.login2 -> enviarhome()
            R.id.Recuperar -> enviarRecuperar()
            R.id.Crear -> enviarSing_in()
        }
    }
}

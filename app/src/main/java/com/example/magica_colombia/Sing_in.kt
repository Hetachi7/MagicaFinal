package com.example.magica_colombia

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class Sing_in : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        setContentView(R.layout.activity_sing_in)

        val nameEditText: EditText = findViewById(R.id.name)
        val emailEditText: EditText = findViewById(R.id.email1)
        val passwordEditText: EditText = findViewById(R.id.password2)
        val registerButton: Button = findViewById(R.id.sing_in2)
        val Singintbtn2=findViewById <Button>(R.id.sing_in2)

        val auth = FirebaseAuth.getInstance()
        Singintbtn2.setOnClickListener(viewListener)

        val Cuentabtn=findViewById <TextView>(R.id.cuenta1)
        Cuentabtn.setOnClickListener(viewListener)
        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Registro exitoso
                            val user = auth.currentUser
                            if (user != null) {
                                // El usuario se ha creado y está disponible
                                // Puedes imprimir el UID del usuario para verificar
                                Log.d("Registro", "Usuario creado con UID: ${user.uid}")
                            } else {
                                // Algo salió mal, el usuario es nulo
                                Log.e("Registro", "Usuario nulo después del registro exitoso")
                            }

                            // Puedes agregar más lógica aquí según tus necesidades
                        } else {
                            // Si falla el registro, muestra un mensaje al usuario
                            Toast.makeText(this, "Error en el registro", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun enviarhome(){
        val intent: Intent = Intent ( this,Home::class.java)
        startActivity(intent)
    }
    fun enviarLogin(){
        val intent: Intent = Intent(this,Login::class.java)
        startActivity(intent)
    }
    private val viewListener = View.OnClickListener {
        when(it.id){
            R.id.sing_in2->enviarhome()
            R.id.cuenta1->enviarLogin()
        }
    }
}
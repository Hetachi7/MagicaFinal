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
        val logintbtn2= findViewById <Button>(R.id.login2)
        logintbtn2.setOnClickListener(viewListener)
        val usernameEditText: EditText = findViewById(R.id.username)
        val passwordEditText: EditText = findViewById(R.id.password)

        val loginButton: Button = findViewById(R.id.login2)


        val auth = FirebaseAuth.getInstance()


        val Recuperarbtn=findViewById<TextView>(R.id.Recuperar)
        Recuperarbtn.setOnClickListener(viewListener)

        val Crearbtn=findViewById <TextView>(R.id.Crear)
        Crearbtn.setOnClickListener(viewListener)
        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Verificar si los campos de correo electrónico y contraseña no están vacíos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Llamar a la autenticación de Firebase
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Inicio de sesión exitoso
                            val user = auth.currentUser
                            // Manejar el usuario como sea necesario
                        } else {
                            // Si falla el inicio de sesión, muestra un mensaje al usuario
                            Toast.makeText(this, "Error en el inicio de sesión", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Mostrar un mensaje si los campos están vacíos
                Toast.makeText(this, "Por favor, ingresa correo y contraseña", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun enviarhome(){
        val intent: Intent = Intent ( this,Home::class.java)
        startActivity(intent)
    }
    fun enviarRecuperar(){
        val intent: Intent = Intent(this,Recuperar::class.java)
        startActivity(intent)
    }
    fun enviarSing_in(){
        val intent: Intent = Intent(this,Sing_in::class.java)
        startActivity(intent)
    }


    private val viewListener = View.OnClickListener {
        when(it.id){
            R.id.login2->enviarhome()
            R.id.Recuperar->enviarRecuperar()
            R.id.Crear->enviarSing_in()
        }
    }
}
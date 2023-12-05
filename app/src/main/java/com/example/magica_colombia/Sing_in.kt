package com.example.magica_colombia

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.magica_colombia.retrofit.retrofit
import com.example.magica_colombia.respons.RespuestaDatos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Sing_in : AppCompatActivity() {

    private lateinit var userNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in) // Reemplaza con el nombre correcto de tu layout

        // Obtén referencias a las vistas
        userNameEditText = findViewById(R.id.name)
        emailEditText = findViewById(R.id.email1)
        passwordEditText = findViewById(R.id.password2)
        confirmPasswordEditText = findViewById(R.id.password3)
        signUpButton = findViewById(R.id.sing_in2)

        // Agrega un Listener al botón de registro
        signUpButton.setOnClickListener {
            // Llama a la función para realizar el registro
            registerUser()
        }
    }

    private fun registerUser() {
        val userName = userNameEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        // Verifica que los campos no estén vacíos
        if (userName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        // Verifica que las contraseñas coincidan
        if (password != confirmPassword) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return
        }

        // Realiza la llamada a la API para el registro
        val call = retrofit.apiService.signUp(userName, email, password, confirmPassword)

        call.enqueue(object : Callback<RespuestaDatos> {
            override fun onResponse(call: Call<RespuestaDatos>, response: Response<RespuestaDatos>) {
                if (response.isSuccessful) {
                    // Registro exitoso
                    Toast.makeText(this@Sing_in, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    // Puedes realizar otras acciones aquí, como navegar a otra actividad
                    Log.d("Registro", "Éxito: ${response.body()}")
                } else {
                    // Error en la respuesta de la API
                    Toast.makeText(this@Sing_in, "Error en el registro", Toast.LENGTH_SHORT).show()
                    Log.e("Registro", "Error en el registro. Código de error: ${response.code()}")
                }
            }


            override fun onFailure(call: Call<RespuestaDatos>, t: Throwable) {
                // Error en la llamada a la API
                Toast.makeText(this@Sing_in, "Error en la conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

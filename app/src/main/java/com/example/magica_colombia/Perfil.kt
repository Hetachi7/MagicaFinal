package com.example.magica_colombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

class Perfil : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
        val btnEditarPerfil: Button = findViewById(R.id.edit)

        // Asigna un OnClickListener para manejar la acción de edición
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Reemplaza el contenido actual con el fragmento de edición
        val fragmentEdicion = EdicionFragment()
        fragmentTransaction.replace(R.id.contenedor_fragment, fragmentEdicion)


        fragmentTransaction.addToBackStack(null)

        fragmentTransaction.commit()
        btnEditarPerfil.setOnClickListener {
            val fragmentoEditarPerfil = EdicionFragment()
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.contenedor_fragment, fragmentoEditarPerfil)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}

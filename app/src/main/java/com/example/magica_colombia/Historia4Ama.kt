package com.example.magica_colombia

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat

class Historia4Ama : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia4_ama)

        val miBoton: Button = findViewById(R.id.next2)
        val drawable = miBoton.background

// Cambiar el color por defecto de la imagen (puedes usar un color específico o obtenerlo desde resources)
        val colorPorDefecto = ContextCompat.getColor(this, R.color.sapo)
        drawable.setColorFilter(colorPorDefecto, PorterDuff.Mode.SRC_ATOP)

    }

}
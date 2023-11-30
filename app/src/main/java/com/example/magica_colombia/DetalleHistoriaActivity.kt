package com.example.magica_colombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


private val <E> List<E>.contenido: CharSequence?
    get() {
        TODO("Not yet implemented")
    }
private val <E> List<E>.titulo: CharSequence?
    get() {
        TODO("Not yet implemented")
    }
private lateinit var dbHelper: DatabaseHelper

class DetalleHistoriaActivity : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var tituloDetalle: TextView
    private lateinit var contenidoDetalle: TextView
    private lateinit var btnEliminar: Button
    private lateinit var btnActualizar: Button

    val historias = dbHelper.getAllHistorias(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_historia)

        dbHelper = DatabaseHelper(this)

        tituloDetalle = findViewById(R.id.tituloDetalle)
        contenidoDetalle = findViewById(R.id.contenidoDetalle)
        btnEliminar = findViewById(R.id.btnEliminar)
        btnActualizar = findViewById(R.id.btnActualizar)

        val historiaId = intent.getLongExtra("historia_id", -1)

        if (historiaId != -1L) {
            mostrarDetallesHistoria(historiaId)
        }

        btnEliminar.setOnClickListener {
            eliminarHistoria(historiaId)
        }

        btnActualizar.setOnClickListener {

        }
    }

    private fun mostrarDetallesHistoria(historiaId: Long) {
        val historia = dbHelper.getAllHistorias(historiaId)

        tituloDetalle.text = historia.titulo
        contenidoDetalle.text = historia.contenido

    }

    private fun eliminarHistoria(historiaId: Long) {
        val rowsAffected = dbHelper.deleteHistoria(historiaId)

        if (rowsAffected > 0) {
            Toast.makeText(this, "Historia eliminada", Toast.LENGTH_SHORT).show()
            finish() // Cierra la actividad después de eliminar
        } else {
            Toast.makeText(this, "Error al eliminar la historia", Toast.LENGTH_SHORT).show()
        }
    }
}

private fun DatabaseHelper.getAllHistorias(context: Long): List<Historia> {
        TODO("Not yet implemented")
}

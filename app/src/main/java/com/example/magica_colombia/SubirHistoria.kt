package com.example.magica_colombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class SubirHistoria : AppCompatActivity() {
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subir_historia)

        dbHelper = DatabaseHelper(this)

        val listaDatos = listOf("Amazonas", "Antioquia", "Arauca","Atlántico"," Bolívar","Boyacá","Caldas","Caquetá","Casanare","Cauca"," Cesar", "Chocó","Córdoba","Cundinamarca","Guainía"," Guaviare","Huila"," Guajira"," Magdalena","Meta","Nariño","Norte de Santander","Putumayo","Quindío","Risaralda","Santander","Sucre","Tolima","Valle del Cauca","Vaupés","Vichada")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaDatos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner: Spinner = findViewById(R.id.Lista)
        spinner.adapter = adapter

        val subirHButton: Button = findViewById(R.id.subirH)
        subirHButton.setOnClickListener {
            val tituloEditText: EditText = findViewById(R.id.titulo)
            val contenidoEditText: EditText = findViewById(R.id.editText)
            val departamentoSpinner: Spinner = findViewById(R.id.Lista)

            val titulo = tituloEditText.text.toString()
            val contenido = contenidoEditText.text.toString()
            val departamento = departamentoSpinner.selectedItem.toString()

            val id = dbHelper.insertHistoria(titulo, contenido, departamento)

            if (id != -1L) {
                // La historia se insertó correctamente
                Toast.makeText(this, "Historia insertada con éxito", Toast.LENGTH_SHORT).show()
            } else {
                // Hubo un error al insertar la historia
                Toast.makeText(this, "Error al insertar la historia", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
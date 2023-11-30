package com.example.magica_colombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class ReportarError : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportarerror)

        val listaDatos = listOf("Bug", "Errores en historias", "Errores en imagenes","Errores en navegabilidad", "Errores en Audios")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaDatos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val spinner: Spinner = findViewById(R.id.Opcionesrepor)
        spinner.adapter = adapter

        val logintbtn2= findViewById <Button>(R.id.ReportB)

        logintbtn2.setOnClickListener(viewListener)
    }
    fun enviarhome(){
        val intent: Intent = Intent ( this,Home::class.java)
        startActivity(intent)
    }
    private val viewListener = View.OnClickListener {
        when(it.id){
            R.id.ReportB->enviarhome()
        }
    }
}
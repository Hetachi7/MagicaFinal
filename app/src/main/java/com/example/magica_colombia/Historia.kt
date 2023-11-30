package com.example.magica_colombia

import android.widget.Button

data class Historia(val id: Long,
                    val titulo: String,
                    val contenido: String,
                    val botonEliminar: Button,
                    val botonActualizar: Button
)


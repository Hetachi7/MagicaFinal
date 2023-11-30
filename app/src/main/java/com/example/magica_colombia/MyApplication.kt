package com.example.magica_colombia

import android.app.Application
import com.google.firebase.FirebaseApp

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        // Aquí puedes agregar cualquier otra configuración de inicialización si es necesario
    }
}
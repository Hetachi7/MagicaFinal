package com.example.magica_colombia.retrofit

import com.example.magica_colombia.`interface`.MyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8000") // Cambia la URL según tu configuración local
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(MyApiService::class.java)

}
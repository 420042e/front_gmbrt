package com.example.gambarte3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.40.0.6:8080/api/" // Reemplaza con la URL base de tu API

    // Inicializa Retrofit
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Crea una instancia de ApiService
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
package com.example.gambarte3.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login") // Reemplaza "login" con la URL adecuada
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
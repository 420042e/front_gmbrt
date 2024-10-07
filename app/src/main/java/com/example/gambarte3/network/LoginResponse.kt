package com.example.gambarte3.network

data class LoginResponse(
    val status: Int,
    val message: String,
    val data: UserData
)

data class UserData(
    val id: Int,
    val username: String
)

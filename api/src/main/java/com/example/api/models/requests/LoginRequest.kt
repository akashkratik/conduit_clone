package com.example.api.models.requests


import com.example.api.models.entities.UserLogin
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val userLogin: UserLogin
)
package com.example.data.remote.model

import com.example.domain.entity.LoginResponseEntity

data class LoginResponse(
    val access_token : String
)
fun LoginResponse.toEntity(): LoginResponseEntity =
    LoginResponseEntity(
        this.access_token
    )
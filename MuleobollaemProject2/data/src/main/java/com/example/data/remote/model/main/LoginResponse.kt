package com.example.data.remote.model.main

import com.example.domain.entity.login.LoginResponseEntity

data class LoginResponse(
    val access_token : String
)
fun LoginResponse.toEntity(): LoginResponseEntity =
    LoginResponseEntity(
        this.access_token
    )
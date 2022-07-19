package com.example.data.mapper

import com.example.data.remote.model.LoginRequest
import com.example.domain.entity.LoginRequestEntity

object LoginMapper {
    fun mapperToLoginRequest(loginRequest: LoginRequestEntity) : LoginRequest =
        loginRequest.run { LoginRequest(id,password, nickname) }
}
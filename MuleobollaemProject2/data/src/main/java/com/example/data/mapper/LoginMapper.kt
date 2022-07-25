package com.example.data.mapper

import com.example.data.remote.model.LoginRequest
import com.example.data.remote.model.LoginResponse
import com.example.domain.entity.LoginRequestEntity
import com.example.domain.entity.LoginResponseEntity

object LoginMapper {

    fun mapperToLoginRequest(loginRequestEntity: LoginRequestEntity): LoginRequest =
        loginRequestEntity.run { LoginRequest(id,password) }

    fun mapperToLoginResponse(loginResponse: LoginResponse): LoginResponseEntity =
        loginResponse.run { LoginResponseEntity(access_token) }
}
package com.example.data.mapper

import com.example.data.remote.model.login.LoginRequest
import com.example.data.remote.model.LoginResponse
import com.example.domain.entity.login.LoginRequestEntity
import com.example.domain.entity.login.LoginResponseEntity

object LoginMapper {

    fun mapperToLoginRequest(loginRequestEntity: LoginRequestEntity): LoginRequest =
        loginRequestEntity.run { LoginRequest(id,password) }

    fun mapperToLoginResponse(loginResponse: LoginResponse): LoginResponseEntity =
        loginResponse.run { LoginResponseEntity(access_token) }
}
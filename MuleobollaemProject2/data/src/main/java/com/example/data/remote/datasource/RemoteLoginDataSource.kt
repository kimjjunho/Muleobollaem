package com.example.data.remote.datasource

import com.example.data.remote.model.LoginRequest
import com.example.data.remote.model.LoginResponse
import com.example.domain.entity.LoginRequestEntity

interface RemoteLoginDataSource {
    suspend fun getLogin(loginRequest: LoginRequest): LoginResponse
}
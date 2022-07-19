package com.example.data.remote.datasource

import com.example.data.remote.model.LoginRequest
import com.example.data.remote.model.LoginResponse

interface RemoteLoginDataSource {
    suspend fun getLogin(loginRequest: LoginRequest): LoginResponse
}
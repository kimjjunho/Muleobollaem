package com.example.data.remote.datasource.login

import com.example.data.remote.model.login.LoginRequest
import com.example.data.remote.model.LoginResponse

interface RemoteLoginDataSource {
    suspend fun getLogin(loginRequest: LoginRequest): LoginResponse
}
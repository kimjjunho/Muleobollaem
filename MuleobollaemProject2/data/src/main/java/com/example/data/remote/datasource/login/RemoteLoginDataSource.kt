package com.example.data.remote.datasource.login

import com.example.data.remote.model.login.LoginRequest
import com.example.data.remote.model.main.LoginResponse

interface RemoteLoginDataSource {
    suspend fun getLogin(loginRequest: LoginRequest): LoginResponse
}
package com.example.data.remote.datasource

import com.example.data.remote.model.SignUpRequest

interface RemoteSignUpDataSource {
    suspend fun signUp(data: SignUpRequest): Unit
}
package com.example.data.remote.datasource

import com.example.data.remote.model.SignUpRequest
import kotlinx.coroutines.flow.Flow

interface RemoteSignUpDataSource {
    suspend fun signUp(data: SignUpRequest)
}
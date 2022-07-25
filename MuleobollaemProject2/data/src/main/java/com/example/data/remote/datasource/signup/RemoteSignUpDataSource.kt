package com.example.data.remote.datasource.signup

import com.example.data.remote.model.signup.SignUpRequest

interface RemoteSignUpDataSource {
    suspend fun signUp(data: SignUpRequest)
}
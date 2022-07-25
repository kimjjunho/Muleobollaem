package com.example.domain.repository

import com.example.domain.entity.signup.SignUpEntity

interface SignUpRepository {
    suspend fun signUp(data: SignUpEntity)
}
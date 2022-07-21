package com.example.domain.repository

import com.example.domain.entity.SignUpEntity

interface SignUpRepository {
    suspend fun signUp(data: SignUpEntity) : Unit
}
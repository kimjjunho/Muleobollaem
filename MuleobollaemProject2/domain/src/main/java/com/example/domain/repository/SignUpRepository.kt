package com.example.domain.repository

interface SignUpRepository {
    suspend fun signUp() : Unit
}
package com.example.domain.repository

import com.example.domain.entity.signup.CheckIdEntity

interface CheckIdRepository {
    suspend fun checkId(data: CheckIdEntity)
}
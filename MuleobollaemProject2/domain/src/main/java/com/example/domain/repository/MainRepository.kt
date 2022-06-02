package com.example.domain.repository

import com.example.domain.entity.MainEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getExchange(): Flow<MainEntity>
}
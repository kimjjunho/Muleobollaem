package com.example.domain.repository

import com.example.domain.entity.main.MainEntity
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getExchange(header: String): Flow<MainEntity>
}
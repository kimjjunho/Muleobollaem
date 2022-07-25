package com.example.domain.repository

import com.example.domain.entity.write.SendWriteEntity

interface SendWriteRepository {
    suspend fun sendWrite(header: String, data: SendWriteEntity)
}
package com.example.domain.repository

import com.example.domain.entity.put.PutPostRequestEntity

interface PutPostRepository {
    suspend fun putPost(header: String, body: PutPostRequestEntity, id: Int)
}
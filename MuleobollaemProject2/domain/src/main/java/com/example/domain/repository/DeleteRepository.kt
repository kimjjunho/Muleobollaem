package com.example.domain.repository

interface DeleteRepository {
    suspend fun deletePost(header: String, id: Int)
}
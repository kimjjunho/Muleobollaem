package com.example.domain.repository

import com.example.domain.entity.comment.CommentResponseEntity
import kotlinx.coroutines.flow.Flow

interface GetCommentRepository {
    suspend fun getCommentRepository(id: Int) : Flow<CommentResponseEntity>
}
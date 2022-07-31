package com.example.domain.repository

import com.example.domain.entity.comment.PutCommentRequestEntity

interface PutCommentRepository {
    suspend fun putComment(header: String, data: PutCommentRequestEntity)
}
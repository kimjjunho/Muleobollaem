package com.example.domain.entity.comment

data class PutCommentRequestEntity(
    val content: String,
    val post_id: Int
)

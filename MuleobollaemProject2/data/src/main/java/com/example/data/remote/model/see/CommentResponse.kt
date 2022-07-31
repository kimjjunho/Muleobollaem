package com.example.data.remote.model.see

import com.example.domain.entity.comment.Comment
import com.example.domain.entity.comment.CommentResponseEntity

data class CommentResponse(
    val comment: List<Comment>
)

fun CommentResponse.toEntity(): CommentResponseEntity =
    CommentResponseEntity(
        this.comment
    )

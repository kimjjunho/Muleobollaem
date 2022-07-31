package com.example.data.local.datasource.comment

import com.example.data.local.entity.CommentRoomEntity
import com.example.domain.entity.comment.CommentResponseEntity

interface LocalGetCommentDataSource {
    suspend fun getComment(): CommentResponseEntity

    suspend fun insertComment(commentRoomEntity: List<CommentRoomEntity>)

    suspend fun updateComment(commentRoomEntity: List<CommentRoomEntity>)
}
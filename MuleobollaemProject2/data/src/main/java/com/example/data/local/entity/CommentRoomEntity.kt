package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.comment.CommentResponseEntity
import com.example.domain.entity.comment.Comment

@Entity(tableName = "comment_room")
data class CommentRoomEntity(
    val username: String,
    val content: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

fun CommentRoomEntity.toComment() =
    Comment(
        this.username,
        this.content
    )

fun List<CommentRoomEntity>.toEntity(): CommentResponseEntity =
    CommentResponseEntity(
        this.map { it.toComment() }
    )

fun Comment.toRoomEntity() =
    CommentRoomEntity(
        username, content
    )

fun CommentResponseEntity.toRoomEntity() = this.comment.map { it.toRoomEntity() }
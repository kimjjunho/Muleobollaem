package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.CommentRoomEntity

@Dao
interface CommentDao {
    @Query("SELECT * FROM comment_room")
    suspend fun getComment(): List<CommentRoomEntity>

    @Query("DELETE FROM comment_room")
    suspend fun deleteComment()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(commentRoomEntity: List<CommentRoomEntity>)

    @Transaction
    suspend fun updateComment(repo: List<CommentRoomEntity>){
        deleteComment()
        insertComment(repo)
    }}
package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.CommentDao
import com.example.data.local.entity.CommentRoomEntity

@Database(
    entities = [CommentRoomEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CommentDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDao
}
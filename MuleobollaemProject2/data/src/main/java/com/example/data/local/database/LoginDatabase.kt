package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.LoginDao
import com.example.data.local.entity.LoginRoomEntity

@Database(
    entities = [LoginRoomEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LoginDatabase: RoomDatabase() {
    abstract fun loginDao(): LoginDao
}
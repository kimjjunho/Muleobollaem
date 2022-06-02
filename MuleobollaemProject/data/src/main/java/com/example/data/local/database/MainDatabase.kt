package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.MainDao
import com.example.data.local.entity.MainRoomEntity

@Database(
    entities = [MainRoomEntity::class],
    version = 1,
    exportSchema = false
)

abstract class MainDatabase: RoomDatabase(){
    abstract fun mainDao() : MainDao
}
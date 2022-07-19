package com.example.data.local.dao

import androidx.room.*
import com.example.data.local.entity.LoginRoomEntity

@Dao
interface LoginDao {
    @Query("SELECT * FROM login_room")
    suspend fun getLogin(): LoginRoomEntity

    @Query("DELETE FROM login_room")
    suspend fun deleteLogin()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchange(mainRoomEntity: LoginRoomEntity)

    @Transaction
    suspend fun updateMain(repo: LoginRoomEntity){
        deleteLogin()
        insertExchange(repo)
    }
}
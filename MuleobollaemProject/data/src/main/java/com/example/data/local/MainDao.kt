package com.example.data.local

import androidx.room.*

@Dao
interface MainDao {
    @Query("SELECT * FROM main_room")
    suspend fun getMain(): List<MainRoomEntity>

    @Query("DELETE FROM main_room")
    suspend fun deleteMain()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMain(mainRoomEntity: List<MainRoomEntity>)

    @Transaction
    suspend fun updateMain(repo: List<MainRoomEntity>){
        deleteMain()
        insertMain(repo)
    }
}
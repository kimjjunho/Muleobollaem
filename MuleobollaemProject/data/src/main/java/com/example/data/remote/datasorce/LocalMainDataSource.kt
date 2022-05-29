package com.example.data.remote.datasorce

import com.example.data.local.MainRoomEntity
import com.example.domain.entity.MainEntity

interface LocalMainDataSource {
    suspend fun getMain(): MainEntity

    suspend fun insertMain(mainRoomEntity: List<MainRoomEntity>)

    suspend fun updateMain(mainRoomEntity: List<MainRoomEntity>)
}
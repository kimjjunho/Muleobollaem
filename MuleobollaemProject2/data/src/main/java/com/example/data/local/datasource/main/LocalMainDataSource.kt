package com.example.data.local.datasource.main

import com.example.data.local.entity.MainRoomEntity
import com.example.domain.entity.main.MainEntity

interface LocalMainDataSource {
    suspend fun getMain(): MainEntity

    suspend fun insertMain(mainRoomEntity: List<MainRoomEntity>)

    suspend fun updateMain(mainRoomEntity: List<MainRoomEntity>)
}
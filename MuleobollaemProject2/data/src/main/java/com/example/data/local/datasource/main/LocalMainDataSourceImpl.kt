package com.example.data.local.datasource.main

import com.example.data.local.dao.MainDao
import com.example.data.local.entity.MainRoomEntity
import com.example.data.local.entity.toEntity
import com.example.domain.entity.MainEntity
import javax.inject.Inject

class LocalMainDataSourceImpl @Inject constructor(
    private val mainDao: MainDao
) : LocalMainDataSource {
    override suspend fun getMain(): MainEntity =
        mainDao.getMain().toEntity()

    override suspend fun insertMain(mainRoomEntity: List<MainRoomEntity>) =
        mainDao.insertExchange(mainRoomEntity)

    override suspend fun updateMain(mainRoomEntity: List<MainRoomEntity>) {
        mainDao.updateMain(mainRoomEntity)
    }

}
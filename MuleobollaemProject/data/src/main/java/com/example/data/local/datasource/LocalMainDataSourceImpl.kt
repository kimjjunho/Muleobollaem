package com.example.data.local.datasource

import com.example.data.local.MainRoomEntity
import com.example.data.local.dao.MainDao
import com.example.data.local.toEntity
import com.example.data.remote.datasorce.LocalMainDataSource
import com.example.domain.entity.MainEntity
import javax.inject.Inject

class LocalMainDataSourceImpl @Inject constructor(
    private val mainDao: MainDao
): LocalMainDataSource{
    override suspend fun getMain(): MainEntity =
        mainDao.getMain().toEntity()


    override suspend fun insertMain(mainRoomEntity: List<MainRoomEntity>) =
        mainDao.insertMain(mainRoomEntity)

    override suspend fun updateMain(mainRoomEntity: List<MainRoomEntity>) {
        mainDao.updateMain(mainRoomEntity)
    }

}
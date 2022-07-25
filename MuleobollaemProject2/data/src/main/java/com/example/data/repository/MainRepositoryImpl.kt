package com.example.data.repository

import com.example.data.local.datasource.main.LocalMainDataSource
import com.example.data.local.entity.toRoomEntity
import com.example.data.remote.datasource.main.RemoteMainDataSource
import com.example.data.remote.model.main.toEntity
import com.example.data.util.OfflineCacheUtil
import com.example.domain.entity.main.MainEntity
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val remoteMainDataSource: RemoteMainDataSource,
    private val localMainDataSource: LocalMainDataSource
): MainRepository {
    override suspend fun getExchange(header: String): Flow<MainEntity> =
        OfflineCacheUtil<MainEntity>()
            .remoteData { remoteMainDataSource.getMain(header).toEntity() }
            .localData { localMainDataSource.getMain() }
            .doOnNeedRefresh { localMainDataSource.updateMain(it.toRoomEntity()) }
            .createFlow()

}
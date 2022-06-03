package com.example.data

import com.example.data.local.LocalMainDataSource
import com.example.data.local.entity.toRoomEntity
import com.example.data.remote.datasource.RemoteMainDataSource
import com.example.data.remote.model.toEntity
import com.example.data.util.OfflineCacheUtil
import com.example.domain.entity.MainEntity
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val remoteMainDataSource: RemoteMainDataSource,
    private val localMainDataSource: LocalMainDataSource
): MainRepository {
    override suspend fun getExchange(): Flow<MainEntity> =
        OfflineCacheUtil<MainEntity>()
            .remoteData { remoteMainDataSource.getMain().toEntity() }
            .localData { localMainDataSource.getMain() }
            .doOnNeedRefresh { localMainDataSource.updateMain(it.toRoomEntity()) }
            .createFlow()

}
package com.example.data.repository

import com.example.data.local.datasource.login.LocalLoginDataSource
import com.example.data.local.entity.toRoomEntity
import com.example.data.mapper.LoginMapper.mapperToLoginRequest
import com.example.data.remote.datasource.RemoteLoginDataSource
import com.example.data.remote.model.toEntity
import com.example.data.util.OfflineCacheUtil
import com.example.domain.entity.LoginRequestEntity
import com.example.domain.entity.LoginResponseEntity
import com.example.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val remoteLoginDataSource: RemoteLoginDataSource,
    private val localLoginDataSource: LocalLoginDataSource
): LoginRepository {
    override suspend fun getLogin(body: LoginRequestEntity): Flow<LoginResponseEntity> =
        OfflineCacheUtil<LoginResponseEntity>()
            .remoteData { remoteLoginDataSource.getLogin(mapperToLoginRequest(body)).toEntity() }
            .localData { localLoginDataSource.getLogin(mapperToLoginRequest(body)) }
            .doOnNeedRefresh { localLoginDataSource.updateLogin(it.toRoomEntity())}
            .createFlow()
}
package com.example.data.local.datasource.login

import com.example.data.local.dao.LoginDao
import com.example.data.local.entity.LoginRoomEntity
import com.example.data.local.entity.toLogin
import com.example.data.remote.model.LoginRequest
import com.example.domain.entity.LoginResponseEntity
import javax.inject.Inject

class LocalLoginDataSourceImpl @Inject constructor(
    private val loginDao: LoginDao
): LocalLoginDataSource {
    override suspend fun getLogin(body: LoginRequest): LoginResponseEntity =
        loginDao.getLogin().toLogin()

    override suspend fun insertLogin(loginRoomEntity: LoginRoomEntity) =
        loginDao.insertExchange(loginRoomEntity)

    override suspend fun updateLogin(loginRoomEntity: LoginRoomEntity) =
        loginDao.updateMain(loginRoomEntity)

}
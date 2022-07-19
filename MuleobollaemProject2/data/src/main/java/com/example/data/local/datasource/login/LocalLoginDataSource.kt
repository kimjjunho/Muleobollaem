package com.example.data.local.datasource.login

import com.example.data.local.entity.LoginRoomEntity
import com.example.data.remote.model.LoginRequest
import com.example.domain.entity.LoginResponseEntity

interface LocalLoginDataSource {
    suspend fun getLogin(body:LoginRequest) : LoginResponseEntity

    suspend fun insertLogin(loginRoomEntity: LoginRoomEntity)

    suspend fun updateLogin(loginRoomEntity: LoginRoomEntity)
}
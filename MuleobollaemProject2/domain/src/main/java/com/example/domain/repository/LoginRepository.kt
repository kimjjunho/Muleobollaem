package com.example.domain.repository

import com.example.domain.entity.LoginRequestEntity
import com.example.domain.entity.LoginResponseEntity
import kotlinx.coroutines.flow.Flow


interface LoginRepository {
    suspend fun getLogin(body: LoginRequestEntity): LoginResponseEntity
}
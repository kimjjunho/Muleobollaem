package com.example.domain.repository

import com.example.domain.entity.login.LoginRequestEntity
import com.example.domain.entity.login.LoginResponseEntity


interface LoginRepository {
    suspend fun getLogin(body: LoginRequestEntity): LoginResponseEntity
}
package com.example.data.remote.datasource.signup

import com.example.data.remote.model.signup.CheckIdRequest

interface RemoteCheckIdDataSource {
    suspend fun checkId(data: CheckIdRequest)
}
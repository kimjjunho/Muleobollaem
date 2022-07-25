package com.example.data.remote.network

import com.example.data.remote.model.MainResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface MainAPI {

    @GET("posts")
    suspend fun getMain(
        @Header("Authorization") header: String
    ): MainResponse
}
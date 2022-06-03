package com.example.data.remote.network

import com.example.data.remote.model.MainResponse
import retrofit2.http.GET

interface MainAPI {

    @GET("posts")
    suspend fun getMain(): MainResponse
}
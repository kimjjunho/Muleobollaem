package com.example.data.remote.network

import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.Path

interface DeleteAPI {

    @DELETE("posts/{post_id}")
    suspend fun deletePost(
        @Header("Authorization") header: String,
        @Path("post_id") post_id: Int
    )
}
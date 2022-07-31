package com.example.data.remote.network

import com.example.data.remote.model.see.CommentResponse
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.Flow

interface CommentAPI {
    @GET("posts/{id}")
    suspend fun getComment(
        @Path("id") id: Int
    ): CommentResponse
}
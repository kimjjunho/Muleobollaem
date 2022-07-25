package com.example.data.remote.model

import com.example.domain.entity.Main
import com.example.domain.entity.MainEntity

data class MainResponse(
    val posts: List<Main>
)
fun MainResponse.toEntity(): MainEntity =
    MainEntity(
        this.posts
    )

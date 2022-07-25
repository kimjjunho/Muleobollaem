package com.example.data.remote.model.main

import com.example.domain.entity.main.Main
import com.example.domain.entity.main.MainEntity

data class MainResponse(
    val posts: List<Main>
)
fun MainResponse.toEntity(): MainEntity =
    MainEntity(
        this.posts
    )

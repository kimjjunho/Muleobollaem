package com.example.data.remote.model

import com.example.domain.entity.MainEntity
import com.example.domain.entity.Main

data class MainResponse(
    val main: List<Main>
)
fun MainResponse.toEntity(): MainEntity =
    MainEntity(
        this.main
    )

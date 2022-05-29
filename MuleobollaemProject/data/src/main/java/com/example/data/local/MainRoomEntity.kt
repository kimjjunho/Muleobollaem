package com.example.data.local

import com.example.domain.entity.MainEntity
import com.example.domain.main.Main

data class MainRoomEntity(
    val name: String
    ){

}

fun Main.toRoomEntity() =
    MainRoomEntity(
        name
    )

fun MainEntity.toRoomEntity() =
    this.mainList.map { it.toRoomEntity() }


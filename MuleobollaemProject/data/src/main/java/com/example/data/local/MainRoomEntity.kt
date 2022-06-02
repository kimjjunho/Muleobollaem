package com.example.data.local

import androidx.room.Entity
import com.example.domain.entity.MainEntity
import com.example.domain.main.Main

@Entity(tableName = "main_room")
data class MainRoomEntity(
    val name: String
    ){

}

fun MainRoomEntity.toMain() =
    Main(
        this.name
    )

fun List<MainRoomEntity>.toEntity(): MainEntity =
    MainEntity(
        this.map { it.toMain() }
    )

fun Main.toRoomEntity() =
    MainRoomEntity(
        name
    )

fun MainEntity.toRoomEntity() =
    this.mainList.map { it.toRoomEntity() }


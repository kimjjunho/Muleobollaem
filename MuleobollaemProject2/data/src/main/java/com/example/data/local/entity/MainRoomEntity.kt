package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.Main
import com.example.domain.entity.MainEntity

@Entity(tableName = "main_room")
data class MainRoomEntity(
    val id_pk:Int,
    val name: String,
    val title: String,
    val main: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

fun MainRoomEntity.toMain() =
    Main(
        this.id_pk,
        this.name,
        this.title,
        this.main
    )

fun List<MainRoomEntity>.toEntity(): MainEntity =
    MainEntity(
        this.map { it.toMain() }
    )

fun Main.toRoomEntity() =
    MainRoomEntity(
        id_pk,
        name,
        title,
        main
    )


fun MainEntity.toRoomEntity() = this.mainList.map { it.toRoomEntity() }


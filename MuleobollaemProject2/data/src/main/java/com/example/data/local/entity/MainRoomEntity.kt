package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.Main
import com.example.domain.entity.MainEntity

@Entity(tableName = "main_room")
data class MainRoomEntity(
    val post_id:Int,
    val title: String,
    val content: String,
    val user_id: String,
    val created_at: String
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

fun MainRoomEntity.toMain() =
    Main(
        this.post_id,
        this.title,
        this.content,
        this.user_id,
        this.created_at
    )

fun List<MainRoomEntity>.toEntity(): MainEntity =
    MainEntity(
        this.map { it.toMain() }
    )

fun Main.toRoomEntity() =
    MainRoomEntity(
        post_id, title, content, user_id, created_at
    )


fun MainEntity.toRoomEntity() = this.posts.map { it.toRoomEntity() }


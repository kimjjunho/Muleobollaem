package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.LoginResponseEntity

@Entity(tableName = "login_room")
data class LoginRoomEntity(
    val access_token: String
){

    @PrimaryKey(autoGenerate = true) var idKey = 0
}

fun LoginRoomEntity.toLogin() =
    LoginResponseEntity(
        this.access_token
    )

fun LoginResponseEntity.toRoomEntity(): LoginRoomEntity =
    LoginRoomEntity(
        access_token
    )
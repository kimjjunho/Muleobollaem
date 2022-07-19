package com.example.data.remote.model

import android.provider.ContactsContract

data class LoginRequest(
    val id: String,
    val password: String,
    val nickname: String
)

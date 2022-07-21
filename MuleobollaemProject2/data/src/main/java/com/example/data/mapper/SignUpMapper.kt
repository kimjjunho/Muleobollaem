package com.example.data.mapper

import com.example.data.remote.model.SignUpRequest
import com.example.domain.entity.SignUpEntity

object SignUpMapper {
    fun mapperToSignUpRequest(signUpEntity: SignUpEntity) : SignUpRequest =
        signUpEntity.run { SignUpRequest(id,password,name) }
}
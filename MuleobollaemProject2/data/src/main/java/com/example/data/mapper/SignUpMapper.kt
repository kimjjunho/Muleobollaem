package com.example.data.mapper

import com.example.data.remote.model.signup.SignUpRequest
import com.example.domain.entity.signup.SignUpEntity

object SignUpMapper {
    fun mapperToSignUpRequest(signUpEntity: SignUpEntity) : SignUpRequest =
        signUpEntity.run { SignUpRequest(id,password,name) }
}
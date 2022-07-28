package com.example.data.mapper

import com.example.data.remote.model.signup.CheckIdRequest
import com.example.data.remote.model.signup.SignUpRequest
import com.example.domain.entity.signup.CheckIdEntity
import com.example.domain.entity.signup.SignUpEntity

object SignUpMapper {
    fun mapperToSignUpRequest(signUpEntity: SignUpEntity) : SignUpRequest =
        signUpEntity.run { SignUpRequest(id,password,name) }
    fun mapperToCheckIdRequest(checkIdEntity: CheckIdEntity) : CheckIdRequest =
        checkIdEntity.run { CheckIdRequest(id) }
}
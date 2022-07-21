package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.entity.SignUpEntity
import com.example.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
): UseCase<SignUpEntity, Unit>() {
    override suspend fun execute(data: SignUpEntity) = signUpRepository.signUp(data)
}
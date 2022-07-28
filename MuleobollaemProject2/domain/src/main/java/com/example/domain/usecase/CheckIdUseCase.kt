package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.entity.signup.CheckIdEntity
import com.example.domain.repository.CheckIdRepository
import javax.inject.Inject

class CheckIdUseCase @Inject constructor(
    private val checkIdRepository: CheckIdRepository
): UseCase<CheckIdEntity,Unit>() {
    override suspend fun execute(data: CheckIdEntity) = checkIdRepository.checkId(data)
}
package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.entity.LoginRequestEntity
import com.example.domain.entity.LoginResponseEntity
import com.example.domain.repository.LoginRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
): UseCase<LoginRequestEntity,Flow<LoginResponseEntity>>() {
    override suspend fun execute(data: LoginRequestEntity): Flow<LoginResponseEntity> = loginRepository.getLogin(data)
}
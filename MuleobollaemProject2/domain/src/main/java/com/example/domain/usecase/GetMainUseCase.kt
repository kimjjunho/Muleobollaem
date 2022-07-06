package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.entity.MainEntity
import com.example.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMainUseCase @Inject constructor(
    private val mainRepository: MainRepository
): UseCase<Unit,Flow<MainEntity>>() {
    override suspend fun execute(data: Unit): Flow<MainEntity> = mainRepository.getExchange()
}
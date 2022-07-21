package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.entity.SendWriteEntity
import com.example.domain.repository.SendWriteRepository
import java.util.concurrent.Flow
import javax.inject.Inject

class SendWriteUseCase @Inject constructor(
    private val sendWriteRepository : SendWriteRepository
):UseCase<SendWriteEntity,Unit>(){
    override suspend fun execute(data: SendWriteEntity): Unit =
        sendWriteRepository.sendWrite()

}
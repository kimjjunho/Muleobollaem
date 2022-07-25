package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.base.UseCaseToken
import com.example.domain.entity.write.SendWriteEntity
import com.example.domain.repository.SendWriteRepository
import javax.inject.Inject

class SendWriteUseCase @Inject constructor(
    private val sendWriteRepository : SendWriteRepository
):UseCaseToken<String,SendWriteEntity,Unit>(){
    override suspend fun execute(header: String,data: SendWriteEntity): Unit =
        sendWriteRepository.sendWrite(header,data)

}
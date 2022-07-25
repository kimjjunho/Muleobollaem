package com.example.domain.usecase

import com.example.domain.base.UseCasePath
import com.example.domain.entity.put.PutPostRequestEntity
import com.example.domain.repository.PutPostRepository
import javax.inject.Inject

class PutPostUseCase @Inject constructor(
    private val putPostRepository: PutPostRepository
): UseCasePath<String, PutPostRequestEntity, Int, Unit>() {
    override suspend fun execute(header: String, body: PutPostRequestEntity, id: Int) {
        putPostRepository.putPost(header,body,id)
    }
}
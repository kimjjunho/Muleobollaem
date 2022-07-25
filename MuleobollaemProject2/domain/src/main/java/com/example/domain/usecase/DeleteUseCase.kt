package com.example.domain.usecase

import com.example.domain.base.UseCaseToken
import com.example.domain.repository.DeleteRepository
import javax.inject.Inject

class DeleteUseCase @Inject constructor(
    private val deleteRepository: DeleteRepository
): UseCaseToken<String, Int, Unit>() {
    override suspend fun execute(header: String, id: Int) {
        deleteRepository.deletePost(header,id)
    }
}
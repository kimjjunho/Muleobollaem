package com.example.domain.usecase

import com.example.domain.base.UseCaseToken
import com.example.domain.entity.comment.PutCommentRequestEntity
import com.example.domain.repository.PutCommentRepository
import javax.inject.Inject

class PutCommentUseCase @Inject constructor(
    private val putCommentRepository: PutCommentRepository
):UseCaseToken<String,PutCommentRequestEntity,Unit>() {
    override suspend fun execute(header: String, data: PutCommentRequestEntity) = putCommentRepository.putComment(header,data)
}
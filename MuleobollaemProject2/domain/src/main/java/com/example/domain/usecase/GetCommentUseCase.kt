package com.example.domain.usecase

import com.example.domain.base.UseCase
import com.example.domain.entity.comment.CommentResponseEntity
import com.example.domain.repository.GetCommentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentUseCase @Inject constructor(
    private val getCommentRepository: GetCommentRepository
): UseCase<Int, Flow<CommentResponseEntity>>(){
    override suspend fun execute(id: Int): Flow<CommentResponseEntity> = getCommentRepository.getCommentRepository(id)
}
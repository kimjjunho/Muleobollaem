package com.example.data.mapper

import com.example.data.remote.model.put.PutCommentRequest
import com.example.data.remote.model.put.PutPostRequest
import com.example.domain.entity.comment.PutCommentRequestEntity

object PutCommentMapper {
    fun mapperToPutComment(putCommentRequestEntity: PutCommentRequestEntity): PutCommentRequest =
        putCommentRequestEntity.run { PutCommentRequest(content,post_id) }
}
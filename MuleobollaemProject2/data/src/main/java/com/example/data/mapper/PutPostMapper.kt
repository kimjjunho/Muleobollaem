package com.example.data.mapper

import com.example.data.remote.model.put.PutPostRequest
import com.example.domain.entity.put.PutPostRequestEntity

object PutPostMapper {
    fun mapperToPutPostRequest(putPostRequestEntity: PutPostRequestEntity): PutPostRequest =
        putPostRequestEntity.run { PutPostRequest(title, content) }
}
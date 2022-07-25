package com.example.data.mapper

import com.example.data.remote.model.write.SendWriteRequest
import com.example.domain.entity.write.SendWriteEntity

object WriteMapper {
    fun mapperToSendWriteRequest(sendWriteEntity: SendWriteEntity): SendWriteRequest =
        sendWriteEntity.run { SendWriteRequest(title,content) }
}
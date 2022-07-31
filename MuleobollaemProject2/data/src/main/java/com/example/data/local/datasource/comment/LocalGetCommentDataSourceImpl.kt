package com.example.data.local.datasource.comment

import com.example.data.local.dao.CommentDao
import com.example.data.local.entity.CommentRoomEntity
import com.example.data.local.entity.toEntity
import com.example.domain.entity.comment.CommentResponseEntity
import javax.inject.Inject

class LocalGetCommentDataSourceImpl @Inject constructor(
    private val commentDao: CommentDao
): LocalGetCommentDataSource{
    override suspend fun getComment(): CommentResponseEntity =
        commentDao.getComment().toEntity()

    override suspend fun insertComment(commentRoomEntity: List<CommentRoomEntity>) =
        commentDao.insertComment(commentRoomEntity)

    override suspend fun updateComment(commentRoomEntity: List<CommentRoomEntity>) {
        commentDao.updateComment(commentRoomEntity)
    }

}
package com.example.data.repository

import com.example.data.local.datasource.comment.LocalGetCommentDataSource
import com.example.data.local.datasource.main.LocalMainDataSource
import com.example.data.local.entity.toRoomEntity
import com.example.data.remote.datasource.see.RemoteGetCommentDataSource
import com.example.data.remote.model.see.toEntity
import com.example.data.util.OfflineCacheUtil
import com.example.domain.entity.comment.CommentResponseEntity
import com.example.domain.repository.GetCommentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCommentRepositoryImpl @Inject constructor(
    private val remoteGetCommentDataSource: RemoteGetCommentDataSource,
    private val localGetCommentDataSource: LocalGetCommentDataSource,
): GetCommentRepository{
    override suspend fun getCommentRepository(id: Int): Flow<CommentResponseEntity> =
        OfflineCacheUtil<CommentResponseEntity>()
            .remoteData { remoteGetCommentDataSource.getComment(id).toEntity() }
            .localData { localGetCommentDataSource.getComment() }
            .doOnNeedRefresh { localGetCommentDataSource.updateComment(it.toRoomEntity()) }
            .createFlow()

}
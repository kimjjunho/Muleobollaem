package com.example.data.repository

import com.example.data.remote.datasource.delete.RemoteDeleteDataSource
import com.example.domain.repository.DeleteRepository
import javax.inject.Inject

class DeleteRepositoryImpl @Inject constructor(
    private val remoteDeleteDataSource: RemoteDeleteDataSource
): DeleteRepository {
    override suspend fun deletePost(header: String, id: Int) {
        remoteDeleteDataSource.deletePost(header,id)
    }
}
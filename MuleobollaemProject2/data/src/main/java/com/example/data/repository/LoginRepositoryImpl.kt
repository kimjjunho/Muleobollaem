package com.example.data.repository
import com.example.data.mapper.LoginMapper.mapperToLoginRequest
import com.example.data.mapper.LoginMapper.mapperToLoginResponse
import com.example.data.remote.datasource.RemoteLoginDataSource
import com.example.domain.entity.LoginRequestEntity
import com.example.domain.entity.LoginResponseEntity
import com.example.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val remoteLoginDataSource: RemoteLoginDataSource
): LoginRepository {
    override suspend fun getLogin(body: LoginRequestEntity): LoginResponseEntity =
        mapperToLoginResponse(remoteLoginDataSource.getLogin(mapperToLoginRequest(body)))
}
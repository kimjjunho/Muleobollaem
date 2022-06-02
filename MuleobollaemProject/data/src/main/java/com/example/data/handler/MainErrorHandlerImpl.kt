package com.example.data.handler

import com.example.domain.base.ErrorHandlerEntity
import com.example.domain.handler.MainErrorHandler
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException


class MainErrorHandlerImpl: MainErrorHandler {
    override fun getMainErrorHandler(throwable: Throwable): ErrorHandlerEntity
    = when(throwable){
        is HttpException -> when(throwable.code()){
            422 -> ErrorHandlerEntity(sendMassage = "입력오류")
            401 -> ErrorHandlerEntity(sendMassage = "토큰오류")
            404 -> ErrorHandlerEntity(sendMassage = "토큰을 찾을 수 없음")
            405 -> ErrorHandlerEntity(sendMassage = "메소드 오류")
            else -> ErrorHandlerEntity(sendMassage = "알 수 없는 오류가 발생했습니다")
        }
        is ConnectException -> ErrorHandlerEntity(sendMassage = "인터넷 연결이 되지 않았습니다")
        is SocketException -> ErrorHandlerEntity(sendMassage = "인터넷 연결이 불안정합니다")
        is UnknownHostException -> ErrorHandlerEntity(sendMassage = "인터넷 연결이 되지 않았습니다")
        else->{
            ErrorHandlerEntity(sendMassage = "Unknown")
        }

    }

}
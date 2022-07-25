package com.example.muleobollaemproject2.feature.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.LoginRequestEntity
import com.example.domain.usecase.LoginUseCase
import com.example.muleobollaemproject2.ACCESS_TOKEN
import com.example.muleobollaemproject2.util.MutableEventFlow
import com.example.muleobollaemproject2.util.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel(){

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    fun login(data: LoginRequestEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                loginUseCase.execute(data)
                ACCESS_TOKEN = "Bearer "+loginUseCase.execute(data).access_token
            }.onSuccess {
                event(Event.SuccessSignUp(true))
            }.onFailure {
                event(Event.ErrorMessage(it.toString()))
            }
        }
    }

    sealed class Event{
        data class SuccessSignUp(var state: Boolean = false) : Event()
        data class ErrorMessage(val errorMessage: String) : Event()
    }
}
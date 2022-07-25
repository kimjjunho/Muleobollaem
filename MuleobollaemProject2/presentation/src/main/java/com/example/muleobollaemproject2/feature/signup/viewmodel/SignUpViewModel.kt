package com.example.muleobollaemproject2.feature.signup.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.ErrorHandlerEntity
import com.example.domain.entity.SignUpEntity
import com.example.domain.usecase.SignUpUseCase
import com.example.muleobollaemproject2.util.MutableEventFlow
import com.example.muleobollaemproject2.util.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalStateException
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
):ViewModel() {

    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }

    fun signUp(data: SignUpEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                signUpUseCase.execute(data)
            }.onSuccess {
                event(Event.SuccessSignUp(true))
            }.onFailure {
                event(Event.ErrorMessage(it.toString()))
                when(it) {
                    is IllegalStateException -> {
                        Log.d("TAG", "illegal 에러 찡찡: ")
                    }
                    else -> {
                        Log.d("TAG", "another exception $it")
                    }
                }
            }
        }
    }

    sealed class Event{
        data class SuccessSignUp(var state: Boolean = false) : Event()
        data class ErrorMessage(val errorMessage: String) : Event()
    }
}
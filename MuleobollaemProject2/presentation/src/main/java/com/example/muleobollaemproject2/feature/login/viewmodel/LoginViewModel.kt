package com.example.muleobollaemproject2.feature.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel(){

}
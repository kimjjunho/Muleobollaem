package com.example.muleobollaemproject2.feature.signup.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.domain.base.UseCase
import com.example.domain.usecase.SignUpUseCase

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
):ViewModel() {

}
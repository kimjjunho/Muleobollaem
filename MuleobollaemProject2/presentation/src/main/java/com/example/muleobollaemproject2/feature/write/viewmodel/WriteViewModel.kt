package com.example.muleobollaemproject2.feature.write.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.write.SendWriteEntity
import com.example.domain.usecase.SendWriteUseCase
import com.example.muleobollaemproject2.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val sendWriteUseCase: SendWriteUseCase
): ViewModel() {

    val success = MutableLiveData<Boolean>()
    val fail = MutableLiveData<String>()

    fun sendWrite(data: SendWriteEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                sendWriteUseCase.execute(ACCESS_TOKEN,data)
            }.onSuccess {
                success.value = true
            }.onFailure {
                fail.value = it.toString()
            }
        }
    }
}
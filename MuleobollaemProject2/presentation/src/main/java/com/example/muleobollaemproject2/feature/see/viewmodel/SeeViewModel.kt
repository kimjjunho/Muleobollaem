package com.example.muleobollaemproject2.feature.see.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.DeleteUseCase
import com.example.muleobollaemproject2.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeViewModel @Inject constructor(
    private val deleteUseCase: DeleteUseCase
):ViewModel(){

    val deleteSuccess = MutableLiveData<Boolean>()
    val deleteFail = MutableLiveData<String>()

    fun deletePost(id: Int){
        viewModelScope.launch {
            kotlin.runCatching {
                deleteUseCase.execute(ACCESS_TOKEN,id)
            }.onSuccess {
                deleteSuccess.value = true
            }.onFailure {
                deleteFail.value = it.toString()
            }
        }
    }
}
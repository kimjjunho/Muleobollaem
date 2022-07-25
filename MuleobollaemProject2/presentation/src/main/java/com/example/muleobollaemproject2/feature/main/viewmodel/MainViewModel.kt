package com.example.muleobollaemproject2.feature.main.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.ErrorHandlerEntity
import com.example.domain.entity.MainEntity
import com.example.domain.usecase.GetMainUseCase
import com.example.muleobollaemproject2.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMainUseCase: GetMainUseCase
):ViewModel(){

    val data = MutableLiveData<MainEntity>()
    val errorMassage = MutableLiveData<String>()

    fun getMain(){
        viewModelScope.launch {
            Log.d(TAG, "getMain: 실행됨")
            try {
                getMainUseCase.execute(ACCESS_TOKEN).collect {
                    Log.d(TAG, "getMain: $it")
                    data.value = it
                }
            }catch (e: ErrorHandlerEntity){
                errorMassage.value = e.sendMessage
            }
        }
    }
}
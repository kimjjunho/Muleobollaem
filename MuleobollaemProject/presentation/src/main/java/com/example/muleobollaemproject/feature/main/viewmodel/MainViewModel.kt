package com.example.muleobollaemproject.feature.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.MainUseCase
import com.example.domain.base.ErrorHandlerEntity
import com.example.domain.entity.MainEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainDataUseCase: MainUseCase
): ViewModel(){

    val data = MutableLiveData<MainEntity>()
    val errorMassage = MutableLiveData<String>()

    fun getMain(){
        viewModelScope.launch {
            try{
                mainDataUseCase.execute(Unit).collect {
                    data.value = it
                }
            }catch (e: ErrorHandlerEntity){
                errorMassage.value = e.sendMassage
            }
        }
    }
}
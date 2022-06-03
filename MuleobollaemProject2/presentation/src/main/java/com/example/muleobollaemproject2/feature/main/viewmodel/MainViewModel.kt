package com.example.muleobollaemproject2.feature.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.base.ErrorHandlerEntity
import com.example.domain.entity.MainEntity
import com.example.domain.usecase.GetMainUseCase
import com.example.muleobollaemproject2.a
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    //private val getMainUseCase: GetMainUseCase
):ViewModel(){

    val data = MutableLiveData<MainEntity>()
    val errorMassage = MutableLiveData<String>()

    fun testViewModel(){
        errorMassage.value = a
    }
   /*fun getMain(){
        viewModelScope.launch {
            try {
                getMainUseCase.execute(Unit).collect {
                    data.value = it
                }
            }catch (e: ErrorHandlerEntity){
                errorMassage.value = e.sendMassage
            }
        }
    }*/
}
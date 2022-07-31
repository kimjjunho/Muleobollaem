package com.example.muleobollaemproject2.feature.see.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.comment.CommentResponseEntity
import com.example.domain.entity.comment.PutCommentRequestEntity
import com.example.domain.entity.put.PutPostRequestEntity
import com.example.domain.usecase.DeleteUseCase
import com.example.domain.usecase.GetCommentUseCase
import com.example.domain.usecase.PutCommentUseCase
import com.example.domain.usecase.PutPostUseCase
import com.example.muleobollaemproject2.ACCESS_TOKEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeeViewModel @Inject constructor(
    private val deleteUseCase: DeleteUseCase,
    private val putPostUseCase: PutPostUseCase,
    private val getCommentUseCase: GetCommentUseCase,
    private val putCommentUseCase: PutCommentUseCase
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

    val putSuccess = MutableLiveData<Boolean>()
    val putFail = MutableLiveData<String>()

    fun putPost(putPostRequestEntity: PutPostRequestEntity, id: Int){
        viewModelScope.launch {
            kotlin.runCatching {
                putPostUseCase.execute(ACCESS_TOKEN,putPostRequestEntity,id)
            }.onSuccess {
                putSuccess.value = true
            }.onFailure {
                putFail.value = it.toString()
            }

        }
    }

    val getCommentSuccess = MutableLiveData<CommentResponseEntity>()
    val getCommentFail = MutableLiveData<String>()

    fun getComment(id: Int){
        viewModelScope.launch {
            kotlin.runCatching {
                getCommentUseCase.execute(id)
            }.onSuccess {
                getCommentUseCase.execute(id).collect {
                    getCommentSuccess.value = it
                }
            }.onFailure {
                getCommentFail.value = it.toString()
            }
        }
    }

    val putCommentSuccess = MutableLiveData<Int>()
    val putCommentFail = MutableLiveData<String>()

    fun putComment(putCommentRequestEntity: PutCommentRequestEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                putCommentUseCase.execute(ACCESS_TOKEN,putCommentRequestEntity)
            }.onSuccess {
                putCommentSuccess.value = putCommentRequestEntity.post_id
            }.onFailure {
                putCommentFail.value = it.toString()
            }
        }
    }
}
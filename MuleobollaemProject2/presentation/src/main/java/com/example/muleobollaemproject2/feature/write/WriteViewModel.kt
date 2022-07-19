package com.example.muleobollaemproject2.feature.write

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.domain.usecase.SendWriteUseCase

class WriteViewModel(
    private val sendWriteUseCase: SendWriteUseCase
): ViewModel() {
}
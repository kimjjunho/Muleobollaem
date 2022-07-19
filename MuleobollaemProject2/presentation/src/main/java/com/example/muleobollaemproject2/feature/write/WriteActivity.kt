package com.example.muleobollaemproject2.feature.write

import android.os.Bundle
import androidx.activity.viewModels
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivityWriteBinding
import com.example.muleobollaemproject2.setStatusBarColorBlack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WriteActivity @Inject constructor() : BaseActivity<ActivityWriteBinding>(R.layout.activity_write) {

    private val writeViewModel : WriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()

        binding.run {
            imageBtnFinish.setOnClickListener {
                finish()
            }
            iamgeBtnBack.setOnClickListener {
                finish()
            }
        }
    }

    override fun observeEvent() {}
}
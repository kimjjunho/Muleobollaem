package com.example.muleobollaemproject2.feature.write.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.example.domain.entity.write.SendWriteEntity
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivityWriteBinding
import com.example.muleobollaemproject2.feature.write.viewmodel.WriteViewModel
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
                writeViewModel.sendWrite(SendWriteEntity(etTitle.text.toString(), etContent.text.toString()))
            }
            iamgeBtnBack.setOnClickListener {
                finish()
            }
        }
    }

    override fun observeEvent() {
        writeViewModel.run {
            success.observe(this@WriteActivity){
                showToastShort("글 쓰기 성공")
                finish()
            }
            fail.observe(this@WriteActivity){
                showToastShort(it)
            }
        }
    }
}
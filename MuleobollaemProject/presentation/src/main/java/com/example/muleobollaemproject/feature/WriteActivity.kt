package com.example.muleobollaemproject.feature

import android.os.Bundle
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.base.BaseActivity
import com.example.muleobollaemproject.databinding.ActivityWriteBinding

class WriteActivity : BaseActivity<ActivityWriteBinding>(R.layout.activity_write) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
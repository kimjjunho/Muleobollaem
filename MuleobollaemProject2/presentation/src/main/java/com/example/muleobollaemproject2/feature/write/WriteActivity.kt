package com.example.muleobollaemproject2.feature.write

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivityWriteBinding
import com.example.muleobollaemproject2.setStatusBarColorBlack

class WriteActivity : BaseActivity<ActivityWriteBinding>(R.layout.activity_write) {
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
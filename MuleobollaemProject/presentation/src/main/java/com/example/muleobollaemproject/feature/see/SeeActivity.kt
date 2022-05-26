package com.example.muleobollaemproject.feature.see

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.base.BaseActivity
import com.example.muleobollaemproject.databinding.ActivitySeeBinding
import com.example.muleobollaemproject.setStatusBarColorBlack

class SeeActivity : BaseActivity<ActivitySeeBinding>(R.layout.activity_see) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()

        val title = intent.getStringExtra("title")
        val main = intent.getStringExtra("main")

        binding.run {
            tvTitle.text = title
            tvMain.text = main
            imageBtnBack.setOnClickListener {
                finish()
            }
        }
    }

    override fun observeEvent() {}
}
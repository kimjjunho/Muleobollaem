package com.example.muleobollaemproject2.feature.see

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivitySeeBinding
import com.example.muleobollaemproject2.setStatusBarColorBlack

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
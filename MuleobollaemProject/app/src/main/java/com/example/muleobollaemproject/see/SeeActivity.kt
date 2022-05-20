package com.example.muleobollaemproject.see

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject.databinding.ActivitySeeBinding
import com.example.muleobollaemproject.setStatusBarColorBlack

class SeeActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivitySeeBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()

        mBinding = ActivitySeeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val main = intent.getStringExtra("main")

        mBinding.tvTitle.text = title
        mBinding.tvMain.text = main

        mBinding.imageBtnBack.setOnClickListener {
            finish()
        }
    }
}
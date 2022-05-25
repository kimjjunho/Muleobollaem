package com.example.muleobollaemproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityWriteBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mBinding.iamgeBtnBack.setOnClickListener {
            finish()
        }
    }
}
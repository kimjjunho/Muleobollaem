package com.example.muleobollaemproject2.feature.see.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivitySeeBinding
import com.example.muleobollaemproject2.feature.main.viewmodel.MainViewModel
import com.example.muleobollaemproject2.feature.see.viewmodel.SeeViewModel
import com.example.muleobollaemproject2.setStatusBarColorBlack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SeeActivity @Inject constructor(): BaseActivity<ActivitySeeBinding>(R.layout.activity_see) {

    private val seeViewModel: SeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()

        val title = intent.getStringExtra("title")
        val main = intent.getStringExtra("main")
        val id = intent.getIntExtra("id",0)

        binding.run {
            tvTitle.text = title
            tvMain.text = main
            imageBtnBack.setOnClickListener {
                finish()
            }

            imageBtnDelete.setOnClickListener {
                seeViewModel.deletePost(id)
                Log.d("TAG", "onCreate: $id")
            }
        }
    }

    override fun observeEvent() {
        seeViewModel.run {
            deleteSuccess.observe(this@SeeActivity){
                showToastShort("글 삭제 성공")
                finish()
            }
            deleteFail.observe(this@SeeActivity){
                showToastShort(it)
            }
        }
    }
}
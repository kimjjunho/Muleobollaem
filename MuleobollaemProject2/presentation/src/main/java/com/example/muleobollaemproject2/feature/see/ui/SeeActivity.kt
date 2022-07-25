package com.example.muleobollaemproject2.feature.see.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import com.example.domain.entity.put.PutPostRequestEntity
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
            tvTitle.setText(title, TextView.BufferType.EDITABLE)
            tvMain.setText(main, TextView.BufferType.EDITABLE)
            btnSetting()

            imageBtnBack.setOnClickListener {
                finish()
            }

            btnDelete.setOnClickListener {
                seeViewModel.deletePost(id)
            }

            btnChange.setOnClickListener {
                seeViewModel.putPost(PutPostRequestEntity(tvTitle.text.toString(),tvMain.text.toString()),id)

                btnChange.visibility = View.INVISIBLE
                btnDelete.visibility = View.VISIBLE
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

            putSuccess.observe(this@SeeActivity){
                showToastShort("글 수정 성공")
            }
            putFail.observe(this@SeeActivity){
                showToastShort(it)
            }
        }
    }

    private fun btnSetting(){
        binding.run {
            tvTitle.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnDelete.visibility = View.INVISIBLE
                    btnChange.visibility = View.VISIBLE
                }
                override fun afterTextChanged(p0: Editable?) {}
            })

            tvMain.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    btnDelete.visibility = View.INVISIBLE
                    btnChange.visibility = View.VISIBLE
                }
                override fun afterTextChanged(p0: Editable?) {}
            })
        }
    }
}
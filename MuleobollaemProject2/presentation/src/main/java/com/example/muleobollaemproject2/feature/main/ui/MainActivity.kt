package com.example.muleobollaemproject2.feature.main.ui

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivityMainBinding
import com.example.domain.entity.Main
import com.example.muleobollaemproject2.a
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.main.MainAdapter
import com.example.muleobollaemproject2.feature.main.viewmodel.MainViewModel
import com.example.muleobollaemproject2.feature.see.SeeActivity
import com.example.muleobollaemproject2.setStatusBarColorBlack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(): BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    //private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()

        val mainArrayList = ArrayList<Main>()
        mainArrayList.add(
            Main(
                0, "김준호", "2학년 1반", "Timetable 에 오류가 났어요 ㅜㅜ 이게 누가 알려주\n" +
                        "실 수 있나요..? "
            )
        )
        mainArrayList.add(Main(1, "장석연", "2학년 2반", "dd"))
        mainArrayList.add(Main(2, "손지원", "2학년 3반", "ㅇㅇ"))
        mainArrayList.add(Main(3, "최성현", "2학년 4반", "ㅎ"))

        binding.iamgeBtnBack.setOnClickListener {
            startActivity(Intent(this, LoginBaseActivity::class.java))
            finish()
        }
        binding.imageBtnWrite.setOnClickListener {
            a = a.plus("0")
            //mainViewModel.testViewModel()
            //startActivity(Intent(this, WriteActivity::class.java))
        }

        binding.rvMain.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMain.setHasFixedSize(true)
        binding.rvMain.adapter = MainAdapter(mainArrayList, this)
    }

    fun moveSee(main: String, title: String) {
        val intent = Intent(applicationContext, SeeActivity::class.java)
        intent.putExtra("main", main)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    override fun observeEvent() {
        /*mainViewModel.run {
            errorMassage.observe(this@MainActivity,{
                Log.d(TAG, "observeEvent: $it")
                showToastShort(it.toString())
            })
            data.observe(this@MainActivity,{
                Log.d(TAG, "observeEvent: $it")
            })
        }*/
    }
}
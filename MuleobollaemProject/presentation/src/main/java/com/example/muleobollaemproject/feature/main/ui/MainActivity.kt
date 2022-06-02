package com.example.muleobollaemproject.feature.main.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.feature.see.SeeActivity
import com.example.muleobollaemproject.base.BaseActivity
import com.example.muleobollaemproject.databinding.ActivityMainBinding
import com.example.muleobollaemproject.feature.WriteActivity
import com.example.muleobollaemproject.feature.login.LoginBaseActivity
import com.example.muleobollaemproject.feature.main.MainAdapter
import com.example.muleobollaemproject.feature.main.MainData
import com.example.muleobollaemproject.feature.main.viewmodel.MainViewModel
import com.example.muleobollaemproject.setStatusBarColorBlack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(): BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    val TAG = "MainActivity"
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()

        val mainArrayList = ArrayList<MainData>()
        mainArrayList.add(
            MainData(
                0, "김준호", "2학년 1반", "Timetable 에 오류가 났어요 ㅜㅜ 이게 누가 알려주\n" +
                        "실 수 있나요..? "
            )
        )
        mainArrayList.add(MainData(1, "장석연", "2학년 2반", "dd"))
        mainArrayList.add(MainData(2, "손지원", "2학년 3반", "ㅇㅇ"))
        mainArrayList.add(MainData(3, "최성현", "2학년 4반", "ㅎ"))

        binding.iamgeBtnBack.setOnClickListener {
            startActivity(Intent(this, LoginBaseActivity::class.java))
            finish()
        }
        binding.imageBtnWrite.setOnClickListener {
            startActivity(Intent(this, WriteActivity::class.java))
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
        Log.d(TAG, "onCreate: ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ")
//        mainViewModel.run {
//            errorMassage.observe(this@MainActivity, {
//                showToast(it.toString())
//            })
//            data.observe(this@MainActivity, {
//
//            })
//        }
    }
}
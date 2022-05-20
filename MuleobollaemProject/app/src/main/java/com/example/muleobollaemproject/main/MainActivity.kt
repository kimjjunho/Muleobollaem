package com.example.muleobollaemproject.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.muleobollaemproject.see.SeeActivity
import com.example.muleobollaemproject.WriteActivity
import com.example.muleobollaemproject.databinding.ActivityMainBinding
import com.example.muleobollaemproject.login.LoginBaseActivity
import com.example.muleobollaemproject.setStatusBarColorBlack
import com.example.muleobollaemproject.setStatusBarTransparent

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityMainBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setStatusBarColorBlack()

        val mainArrayList = ArrayList<MainData>()
        mainArrayList.add(MainData("김준호","2학년 1반","Timetable 에 오류가 났어요 ㅜㅜ 이게 누가 알려주\n" +
                "실 수 있나요..? "))
        mainArrayList.add(MainData("장석연","2학년 2반","dd"))
        mainArrayList.add(MainData("손지원","2학년 3반","ㅇㅇ"))
        mainArrayList.add(MainData("최성현","2학년 4반","ㅎ"))

        mBinding.iamgeBtnBack.setOnClickListener {
            startActivity(Intent(this, LoginBaseActivity::class.java))
            finish()
        }
        mBinding.imageBtnWrite.setOnClickListener {
            startActivity(Intent(this,WriteActivity::class.java))
        }

        mBinding.rvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        mBinding.rvMain.setHasFixedSize(true)
        mBinding.rvMain.adapter = MainAdapter(mainArrayList,this)

    }

    fun moveSee(main : String, title : String){
        val intent = Intent(applicationContext, SeeActivity::class.java)
        intent.putExtra("main",main)
        intent.putExtra("title",title)
        startActivity(intent)
    }
}
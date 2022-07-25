package com.example.muleobollaemproject2.feature.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivityMainBinding
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.main.adapter.MainAdapter
import com.example.muleobollaemproject2.feature.main.viewmodel.MainViewModel
import com.example.muleobollaemproject2.feature.see.ui.SeeActivity
import com.example.muleobollaemproject2.feature.write.ui.WriteActivity
import com.example.muleobollaemproject2.setStatusBarColorBlack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(): BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColorBlack()
        binding.activity = this

        mainViewModel.getMain()

        binding.iamgeBtnBack.setOnClickListener {
            startActivity(Intent(this, LoginBaseActivity::class.java))
            finish()
        }


    }

    fun moveSee(main: String, title: String) {
        val intent = Intent(applicationContext, SeeActivity::class.java)
        intent.putExtra("main", main)
        intent.putExtra("title", title)
        startActivity(intent)
    }

    fun moveToLogin(){
        startActivity(Intent(this, WriteActivity::class.java))
    }

    override fun observeEvent() {
        mainViewModel.run {
            errorMassage.observe(this@MainActivity) {
                showToastShort(it.toString())
            }
            data.observe(this@MainActivity) {
                binding.rvMain.setHasFixedSize(true)
                binding.rvMain.adapter = MainAdapter(it.posts, this@MainActivity)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getMain()
    }
}
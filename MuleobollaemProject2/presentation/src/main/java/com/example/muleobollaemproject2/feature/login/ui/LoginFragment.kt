package com.example.muleobollaemproject2.feature.login.ui

import android.content.Intent
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseFragment
import com.example.muleobollaemproject2.databinding.FragmentLoginBinding
import com.example.muleobollaemproject2.feature.main.MainActivity
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    override fun initView() {
        val loginBaseActivity = activity as LoginBaseActivity
        binding.run {
            btnSign.setOnClickListener {
                loginBaseActivity.fragmentChange()
            }
            imageBtnSign.setOnClickListener {
                loginBaseActivity.fragmentChange()
            }
            btnLogin.setOnClickListener {
                startActivity(Intent(loginBaseActivity, MainActivity::class.java))
                loginBaseActivity.finish()
            }
        }
    }
    override fun observeEvent() {}
}
package com.example.muleobollaemproject.feature.login.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.base.BaseFragment
import com.example.muleobollaemproject.feature.main.ui.MainActivity
import com.example.muleobollaemproject.databinding.FragmentLoginBinding
import com.example.muleobollaemproject.feature.login.LoginBaseActivity


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
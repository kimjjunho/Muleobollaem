package com.example.muleobollaemproject2.feature.login.ui

import android.content.Intent
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseFragment
import com.example.muleobollaemproject2.databinding.FragmentLoginBinding
import com.example.muleobollaemproject2.feature.main.ui.MainActivity
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    private val loginViewModel by activityViewModels<LoginViewModel>()

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
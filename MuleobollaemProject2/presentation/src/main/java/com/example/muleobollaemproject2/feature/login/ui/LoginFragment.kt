package com.example.muleobollaemproject2.feature.login.ui

import android.content.Intent
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.domain.entity.LoginRequestEntity
import com.example.muleobollaemproject2.ACCESS_TOKEN
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseFragment
import com.example.muleobollaemproject2.databinding.FragmentLoginBinding
import com.example.muleobollaemproject2.feature.main.ui.MainActivity
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.login.viewmodel.LoginViewModel
import com.example.muleobollaemproject2.feature.login.viewmodel.LoginViewModel.Event
import com.example.muleobollaemproject2.util.repeatOnStarted
import kotlinx.coroutines.flow.collect

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
                loginViewModel.login(LoginRequestEntity(etId.text.toString(),etPassword.text.toString()))
            }
        }
    }
    override fun observeEvent() {
        repeatOnStarted {
            loginViewModel.eventFlow.collect { handlerEvent(it) }
        }
    }

    private fun handlerEvent(event: Event) = when(event){
        is Event.SuccessSignUp -> {
            val loginBaseActivity = activity as LoginBaseActivity
            startActivity(Intent(loginBaseActivity, MainActivity::class.java))
            loginBaseActivity.finish()

            Log.d("TAG", ACCESS_TOKEN)
        }
        is Event.ErrorMessage -> showToast(event.errorMessage)
        else -> {}
    }
}
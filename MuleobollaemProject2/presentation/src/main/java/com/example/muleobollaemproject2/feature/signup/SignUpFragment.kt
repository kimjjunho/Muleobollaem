package com.example.muleobollaemproject2.feature.signup

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.domain.entity.SignUpEntity
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseFragment
import com.example.muleobollaemproject2.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.signup.viewmodel.SignUpViewModel
import com.example.muleobollaemproject2.feature.signup.viewmodel.SignUpViewModel.Event
import com.example.muleobollaemproject2.util.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    private val signUpViewModel by activityViewModels<SignUpViewModel>()

    override fun initView(){
        val loginBaseActivity = activity as LoginBaseActivity
        binding.run {
            imageBtnBack.setOnClickListener {
                loginBaseActivity.onBackPressed()
            }
            btnIdCheck.setOnClickListener {
                Toast.makeText(context, "시용 가능한 아이디입니다!!", Toast.LENGTH_SHORT).show()
            }
            btnSignUp.setOnClickListener {
                signUpViewModel.signUp(SignUpEntity(etId.text.toString(),etPassword.text.toString(),etName.text.toString()))
            }
        }
    }

    override fun observeEvent() {
        repeatOnStarted {
            signUpViewModel.eventFlow.collect { handlerEvent(it) }
        }
    }

    private fun handlerEvent(event: Event) = when(event){

        is Event.SuccessSignUp -> {
            val loginBaseActivity = activity as LoginBaseActivity
            loginBaseActivity.onBackPressed()
        }
        is Event.ErrorMessage -> { showToast(event.errorMessage)}
        else -> { showToast("전혀 알 수 없는 오류입니다.") }
    }
}
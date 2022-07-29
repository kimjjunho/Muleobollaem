package com.example.muleobollaemproject2.feature.signup.ui

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.domain.entity.signup.CheckIdEntity
import com.example.domain.entity.signup.SignUpEntity
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseFragment
import com.example.muleobollaemproject2.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.signup.viewmodel.SignUpViewModel
import com.example.muleobollaemproject2.feature.signup.viewmodel.SignUpViewModel.Event
import com.example.muleobollaemproject2.util.repeatOnStarted
import kotlinx.coroutines.flow.collect

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    private var idCheck = false
    private val signUpViewModel by activityViewModels<SignUpViewModel>()


    override fun initView(){
        val loginBaseActivity = activity as LoginBaseActivity

        idTextChange()

        binding.run {
            imageBtnBack.setOnClickListener {
                loginBaseActivity.onBackPressed()
            }
            btnIdCheck.setOnClickListener {
                signUpViewModel.idCheck(CheckIdEntity(etId.text.toString()))
            }
            btnSignUp.setOnClickListener {
                if(idCheck){
                    signUpViewModel.signUp(SignUpEntity(etId.text.toString(),etPassword.text.toString(),etName.text.toString()))
                }else{
                    showToast("아이디 중복 여부를 확인해 주세요")
                }
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
            showToast("회원가입을 성공하셨습니다!")

            val loginBaseActivity = activity as LoginBaseActivity
            loginBaseActivity.onBackPressed()
        }
        is Event.CheckId -> {
            showToast("사용 가능한 아이디입니댜")
            idCheck = true
        }
        is Event.ErrorMessage -> { showToast(event.errorMessage)}
        else -> { showToast("전혀 알 수 없는 오류입니다.") }
    }

    private fun idTextChange(){
        binding.run {
            etId.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    idCheck = false
                }
                override fun afterTextChanged(p0: Editable?) {}
            })
        }
    }

}
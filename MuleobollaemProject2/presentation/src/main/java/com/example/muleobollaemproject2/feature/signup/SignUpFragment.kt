package com.example.muleobollaemproject2.feature.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseFragment
import com.example.muleobollaemproject2.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject2.feature.login.LoginBaseActivity
import com.example.muleobollaemproject2.feature.login.viewmodel.LoginViewModel
import com.example.muleobollaemproject2.feature.signup.viewmodel.SignUpViewModel

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
        }
    }

    override fun observeEvent() {}
}
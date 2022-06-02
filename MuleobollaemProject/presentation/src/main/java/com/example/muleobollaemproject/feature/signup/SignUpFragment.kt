package com.example.muleobollaemproject.feature.signup

import android.widget.Toast
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.base.BaseFragment
import com.example.muleobollaemproject.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject.feature.login.LoginBaseActivity

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {
    override fun initView(){
        val loginBaseActivity = activity as LoginBaseActivity
        binding.run {
            imageBtnBack.setOnClickListener {
                loginBaseActivity.onBackPressed()
            }
            btnIdCheck.setOnClickListener {
                Toast.makeText(context, "시용 가능한 아이디입니다!!",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun observeEvent() {}
}
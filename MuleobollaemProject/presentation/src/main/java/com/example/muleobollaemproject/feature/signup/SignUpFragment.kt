package com.example.muleobollaemproject.feature.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.base.BaseFragment
import com.example.muleobollaemproject.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject.feature.login.LoginBaseActivity

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(R.layout.fragment_sign_up) {
    override fun initView(){
        val loginBaseActivity = activity as LoginBaseActivity

        binding.imageBtnBack.setOnClickListener {
            loginBaseActivity.onBackPressed()
        }
        binding.btnIdCheck.setOnClickListener {
            Toast.makeText(context, "시용 가능한 아이디입니다!!",Toast.LENGTH_SHORT).show()
        }
    }

    override fun observeEvent() {}
}
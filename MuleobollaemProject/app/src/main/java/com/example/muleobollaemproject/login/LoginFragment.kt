package com.example.muleobollaemproject.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muleobollaemproject.main.MainActivity
import com.example.muleobollaemproject.databinding.FragmentLoginBinding
import com.example.muleobollaemproject.setStatusBarTransparent


class LoginFragment : Fragment() {

    private lateinit var mBinding : FragmentLoginBinding
    private val binding get() = mBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentLoginBinding.inflate(inflater,container,false)
        val view = binding.root
        val loginBaseActivity = activity as LoginBaseActivity

        mBinding.btnSign.setOnClickListener {
            loginBaseActivity.fragmentChange()
        }
        mBinding.imageBtnSign.setOnClickListener {
            loginBaseActivity.fragmentChange()
        }
        mBinding.btnLogin.setOnClickListener {
            startActivity(Intent(loginBaseActivity, MainActivity::class.java))
            loginBaseActivity.finish()
        }

        return view
    }

    companion object {

    }
}
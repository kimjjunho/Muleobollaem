package com.example.muleobollaemproject.signup

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject.login.LoginBaseActivity
import kotlin.math.log

class SignUpFragment : Fragment() {

    private lateinit var mBinding: FragmentSignUpBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentSignUpBinding.inflate(inflater,container,false)
        val view = binding.root
        val loginBaseActivity = activity as LoginBaseActivity

        mBinding.imageBtnBack.setOnClickListener {
            loginBaseActivity.onBackPressed()
        }

        return view
    }

    companion object {
    }
}
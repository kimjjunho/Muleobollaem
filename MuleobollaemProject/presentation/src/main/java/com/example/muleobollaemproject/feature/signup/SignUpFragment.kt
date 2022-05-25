package com.example.muleobollaemproject.feature.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.muleobollaemproject.databinding.FragmentSignUpBinding
import com.example.muleobollaemproject.feature.login.LoginBaseActivity

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
        mBinding.btnIdCheck.setOnClickListener {
            Toast.makeText(context, "시용 가능한 아이디입니다!!",Toast.LENGTH_SHORT).show()
        }

        return view
    }

    companion object {
    }
}
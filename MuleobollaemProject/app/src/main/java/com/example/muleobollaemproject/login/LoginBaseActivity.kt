package com.example.muleobollaemproject.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.databinding.ActivityLoginBaseBinding
import com.example.muleobollaemproject.signup.SignUpFragment

class LoginBaseActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityLoginBaseBinding
    private val binding get() = mBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,LoginFragment()).commit()
    }

    fun fragmentChange(check : Int){
        when(check){
            1->{
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frameLayout,SignUpFragment())

                transaction.addToBackStack(null)
                transaction.commit()
            }
            2->{
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout,LoginFragment()).commit()
            }
        }
    }
}
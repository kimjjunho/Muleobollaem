package com.example.muleobollaemproject2.feature.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.muleobollaemproject2.R
import com.example.muleobollaemproject2.base.BaseActivity
import com.example.muleobollaemproject2.databinding.ActivityLoginBaseBinding
import com.example.muleobollaemproject2.feature.login.ui.LoginFragment
import com.example.muleobollaemproject2.feature.signup.SignUpFragment
import com.example.muleobollaemproject2.setStatusBarTransparent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginBaseActivity : BaseActivity<ActivityLoginBaseBinding>(R.layout.activity_login_base) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarTransparent()
        fragmentSet()

    }

    private fun fragmentSet(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, LoginFragment())
            .commit()
    }

    fun fragmentChange(){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, SignUpFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun observeEvent() {}
}
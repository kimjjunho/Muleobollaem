package com.example.muleobollaemproject.feature.login
import android.os.Bundle
import com.example.muleobollaemproject.R
import com.example.muleobollaemproject.base.BaseActivity
import com.example.muleobollaemproject.databinding.ActivityLoginBaseBinding
import com.example.muleobollaemproject.feature.login.ui.LoginFragment
import com.example.muleobollaemproject.setStatusBarTransparent
import com.example.muleobollaemproject.feature.signup.SignUpFragment

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
package com.example.muleobollaemproject2.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
):AppCompatActivity() {
    protected lateinit var binding: B


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,layoutId)
        binding.lifecycleOwner = this

        observeEvent()
    }

    fun showToastLong(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
    fun showToastShort(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
    
    abstract fun observeEvent()
}
package com.example.muleobollaemproject2

import android.app.Activity
import android.view.View
import android.view.WindowManager

fun Activity.setStatusBarTransparent(){
    window.apply {
        setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}

fun Activity.setStatusBarColorBlack(){
    setStatusBarTransparent()
    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
}
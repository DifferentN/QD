package com.example.qd.logn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.qd.R
import com.example.qd.clockIn.ClockIn

class LognInActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in);
    }
    fun signInFinish(view:View){
        var intent: Intent = Intent(this, ClockIn::class.java)
        startActivity(intent)
    }
    fun GoToSignUp(view:View){
        var intent: Intent = Intent(this, LognUpActivity::class.java)
        startActivity(intent)
    }
}
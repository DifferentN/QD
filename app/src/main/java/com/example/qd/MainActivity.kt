package com.example.qd

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.util.Log
import android.view.View
import com.example.qd.logn.LognInActivity

class MainActivity : AppCompatActivity() {
    var edit:TextInputLayout ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit = findViewById<TextInputLayout>(R.id.testMDtext)
        edit?.setHintEnabled(false)

    }
    fun click(view: View){
        edit?.setHintEnabled(false)
        edit?.hint=""
        Log.i("LZH","click")
        var intent: Intent = Intent(this,LognInActivity::class.java)
        startActivity(intent)
    }
}

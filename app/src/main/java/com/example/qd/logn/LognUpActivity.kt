package com.example.qd.logn

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.qd.R
import com.example.qd.clockIn.ClockIn
import kotlinx.android.synthetic.main.sign_up.*
import java.util.regex.Pattern


class LognUpActivity: AppCompatActivity() {
//    var nameInputView:TextInputLayout?=null
    var maxTextLen:Int = 6
    var phoneText:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)


        setListener()

    }
    fun setListener(){
        signUpNameTextInput?.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                if(count>maxTextLen){
                    signUpNameInput.error = "不能大于6个字"
                    signUpNameInput.isErrorEnabled = true
                }else{
                    signUpNameInput.isErrorEnabled = false
                }
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })


        signUpNamePhoneTextInput?.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                phoneText= s?.toString()?:""
                signUpNamePhoneInput.isErrorEnabled = false
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
        signUpNamePhoneTextInput?.setOnFocusChangeListener(object :View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                var len:Int= phoneText?.length?:0
                if(len>0){
                    val phone:String = phoneText?:""
                    if(!isPhone(phone)){
                        signUpNamePhoneInput.error = "手机号错误"
                        signUpNamePhoneInput.isErrorEnabled = true
                    }
                }
            }

        })


    }

    fun isPhone(phone: String): Boolean {
        val regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$"
        if (phone.length != 11) {
            return false
        } else {
            val p = Pattern.compile(regex)
            val m = p.matcher(phone)
            val isMatch = m.matches()
            return isMatch
        }
    }
    fun signUpFinish(view:View){
        var intent:Intent = Intent(this,ClockIn::class.java)
        startActivity(intent)
    }
}
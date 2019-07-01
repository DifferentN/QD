package com.example.qd.setting

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.qd.R
import kotlinx.android.synthetic.main.activity_aboutus.*
import kotlinx.android.synthetic.main.top_block.*

class Aboutus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)
        initTopBlock()
        initData()
    }
    fun initTopBlock(){
        topLeftImageView.setImageResource(R.drawable.left_arrow)
        topLeftTextView.text = ""
        topRightTextView.text = "关于我们"
        topMiddleText.text = ""

        topLeftImageView.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                this@Aboutus.finish()
            }

        })
    }
    fun initData(){
        var text="1、项目名称：签到APP\n"
        text+="2、团队成员：彭丹泓，钟钰婷，郑勇杰，李政浩，陈忆鹭\n"
        text+="3、APP已完成功能：全部功能\n"
        text+="4、意见和建议：无"
        textView.text = text
    }
}

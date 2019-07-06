package com.example.qd.myself

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qd.MyApplication

import com.example.qd.R
import com.example.qd.dao.PersonalInfo
import com.example.qd.setting.Setting
import kotlinx.android.synthetic.main.my_self_fragment.*

class MySelfFragment : Fragment() {

    companion object {
        fun newInstance() = MySelfFragment()
    }

    private lateinit var viewModel: MySelfViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_self_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MySelfViewModel::class.java)
        // TODO: Use the ViewModel
        initData()
    }
    fun initData(){
        var personalInfo = (activity!!.application as MyApplication).getPersonalInfo()
        mySelfName.text = "姓名: "+personalInfo?.personalName
        mySelfPhone.text = "学校: "+personalInfo?.school
    }

}

package com.ksm.smplayerproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.ksm.smplayerproject.Tool.testClass
import com.ksm.smplayerproject.UI.AppToolBar

class MainActivity : AppCompatActivity() {
    private var toolbar : AppToolBar? =null
    private var testInter :testClass? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.tool_maintool) as AppToolBar
//        toolbar?.setRightOnClickListener(object : AppToolBar.RightOnClickListener{
//            override fun rightOnClickListener() {
//                Toast.makeText(this@MainActivity,"点击了右边",Toast.LENGTH_SHORT).show()
//            }
//        })

    }
}

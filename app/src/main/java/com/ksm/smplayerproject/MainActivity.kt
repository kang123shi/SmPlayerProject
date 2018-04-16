package com.ksm.smplayerproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.ksm.smplayerproject.UI.AppToolBar

class MainActivity : AppCompatActivity() {
    private var toolbar : AppToolBar? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.tool_maintool) as AppToolBar
        toolbar!!.setToolTilte("我的鑫鑫标题")
        toolbar.setRightOnClickListener()
    }
}

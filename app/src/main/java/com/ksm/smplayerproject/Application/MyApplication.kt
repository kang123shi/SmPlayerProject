package com.ksm.smplayerproject.Application

import android.app.Application
import android.content.Context
import com.lody.turbodex.TurboDex

/**
 * Created by Administrator on 2018/4/13 0013.
 */
class MyApplication  : Application(){

    override fun attachBaseContext(base: Context?) {
        TurboDex.enableTurboDex()
        super.attachBaseContext(base)
    }
    override fun onCreate() {
        super.onCreate()
    }
}
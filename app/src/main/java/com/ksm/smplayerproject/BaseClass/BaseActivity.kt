package com.ksm.smplayerproject.BaseClass

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.ksm.smplayerproject.R
import com.ksm.smplayerproject.Tool.AppManager

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        AppManager.addActivity(this)
    }

   fun skipActivityforClass(activity: Activity,target: Class<out Activity>,bundle: Bundle){
       if (activity==null){
           return
       }
       intent  = Intent(activity,target)
       if (bundle!= null){
           intent.putExtras(bundle)
       }
       activity.startActivity(intent)
       overridePendingTransition(R.anim.base_slide_right_in,R.anim.base_slide_remain)
   }
}

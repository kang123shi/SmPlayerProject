package com.ksm.smplayerproject.UI

import android.content.Context
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ksm.smplayerproject.R

/**
 * Created by Administrator on 2018/4/16 0016.
 */

class AppToolBar : Toolbar {
     private var myToolbar :Toolbar? = null
     private var leftText : TextView? =null
     private var rightText : TextView? =null
     private var leftImg : ImageView ? =null
     private var rightImg : ImageView? = null
     private var mInflater : LayoutInflater? =null
     private var mainTitlt : TextView? =null
     private var mView :View? = null
    constructor(context: Context?) : super(context){initView(context)}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){initView(context)}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){initView(context)}
    interface LeftOnClickListener{
        fun leftOnClickListener()
    }
    interface RightOnClickListener{
        fun rightOnClickListener()
    }
    public var leftListener : LeftOnClickListener? =null
    fun setLeftOnClickListener(leftOnClickListener: LeftOnClickListener){
        this.leftListener = leftOnClickListener
    }
    public var rightListener : RightOnClickListener? =null
    fun setRightOnClickListener(rightListener : RightOnClickListener){
        this.rightListener = rightListener
    }
    private fun initView(context: Context?) {
        if (mView == null){
            mInflater = LayoutInflater.from(context)
            mView = mInflater!!.inflate(R.layout.toolbar_layout,null)
            leftText = mView?.findViewById(R.id.tv_lefttext) as TextView
            leftImg = mView?.findViewById(R.id.iv_leftImg) as ImageView
            rightText = mView?.findViewById(R.id.tv_righttext) as TextView
            rightImg = mView?.findViewById(R.id.iv_rightImg) as ImageView
            mainTitlt = mView?.findViewById(R.id.tv_toolbar_title) as TextView
            mainTitlt!!.text = ""
            var params : LayoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL)
            addView(mView,params)
        }
        setContentInsetsRelative(0,0)
        leftImg!!.setOnClickListener { leftListener?.leftOnClickListener()}
        leftText!!.setOnClickListener { leftListener?.leftOnClickListener() }
        rightImg!!.setOnClickListener { rightListener?.rightOnClickListener() }
        rightText!!.setOnClickListener { rightListener?.rightOnClickListener() }
    }
    fun setToolTilte(title:String){
        mainTitlt!!.visibility = View.VISIBLE
        mainTitlt!!.text=title
    }
    fun setRightText(rightText:String){
        rightImg!!.visibility = View.GONE
        this.rightText!!.visibility = View.VISIBLE
        this.rightText!!.text = rightText
    }
    fun setRightImg(resid : Int){
        rightText!!.visibility = View.GONE
        rightImg!!.visibility = View.VISIBLE
        rightImg!!.setBackgroundResource(resid)
    }
    fun setLeftImg(resid: Int){
        leftText!!.visibility= View.GONE
        leftImg!!.visibility = View.VISIBLE

        leftImg!!.setBackgroundResource(resid)
    }
    fun setLeftText(lefttext :String){
        leftImg!!.visibility = View.GONE
        leftText!!.visibility = View.VISIBLE

        leftText!!.text = lefttext
    }

}

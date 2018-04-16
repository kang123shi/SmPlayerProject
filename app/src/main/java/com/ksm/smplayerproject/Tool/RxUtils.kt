package com.ksm.smplayerproject.Tool

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Administrator on 2018/4/16 0016.
 */
object RxUtils {
    val compositeDisposable  = CompositeDisposable()

    fun clearDisposable(){
        if (compositeDisposable!=null){
            compositeDisposable.clear()
        }
    }
    fun addDisposable(disposable: Disposable){
        if (compositeDisposable!=null){
            compositeDisposable.add(disposable)
        }

    }
}
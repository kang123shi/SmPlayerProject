package com.ksm.smplayerproject.Http

import com.ksm.smplayerproject.Tool.RxUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2018/4/16 0016.
 */
class NetWorkRequest {
    fun <M> addObservable(observable: Observable<M>,disposable: DisposableObserver<M>){
         RxUtils.addDisposable(observable.subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeWith(disposable))
    }

}
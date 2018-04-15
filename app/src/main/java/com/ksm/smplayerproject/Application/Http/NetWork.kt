package com.ksm.smplayerproject.Application.Http

import com.zhy.http.okhttp.log.LoggerInterceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Administrator on 2018/4/14.
 */
class NetWork {
      private val gsonConverterFactory : Converter.Factory = GsonConverterFactory.create()
      private val rxJavaCallAdapterFactory :CallAdapter.Factory = RxJavaCallAdapterFactory.create()
      private var httpApi : HttpApi? = null
      public fun getHttpApi : HttpApi{
          if (httpApi==null){
              httpApi =getRetrofit(API.)
          }
      }
      private fun getRetrofit(baseUrl : String) :Retrofit{
          return Retrofit.Builder()
                  .client(OkHttpClient.Builder().addInterceptor { LoggerInterceptor() }.build())
                  .baseUrl(baseUrl)
                  .addConverterFactory(gsonConverterFactory)
                  .addCallAdapterFactory(rxJavaCallAdapterFactory)
                  .build()
      }
}
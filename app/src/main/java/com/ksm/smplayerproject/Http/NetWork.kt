package com.ksm.smplayerproject.Http

import android.util.Log
import com.ksm.smplayerproject.Application.APPConstant
import com.zhy.http.okhttp.log.LoggerInterceptor
import okhttp3.*
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
      fun getHttpApi() : HttpApi{
          if (httpApi==null){
              httpApi =getRetrofit(API.MAIN_API).create(HttpApi::class.java)
          }
          return httpApi!!
      }
      private fun getRetrofit(baseUrl : String) :Retrofit{
          return Retrofit.Builder()
                  .client(OkHttpClient.Builder().addInterceptor(LogInterceptor()).build())
                  .baseUrl(baseUrl)
                  .addConverterFactory(gsonConverterFactory)
                  .addCallAdapterFactory(rxJavaCallAdapterFactory)
                  .build()
      }

      private class LogInterceptor : Interceptor{
          override fun intercept(chain: Interceptor.Chain?): Response {
              val request  = chain?.request()
              Log.i(APPConstant.LOG_KEY, "request:" + request.toString())
              val response = chain?.proceed(chain?.request())
              val mediaType = response?.body()?.contentType()
              val content  = response?.body()?.string()
              Log.i(APPConstant.LOG_KEY, "response body:" + content)
              if (response?.body()!=null){
                  val body = ResponseBody.create(mediaType,content)
                  return response.newBuilder().body(body).build()
              }else{
                  return response!!
              }
          }
      }
}
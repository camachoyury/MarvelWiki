package com.camachoyury.marvelwiki.data.repository

import android.content.res.Resources
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException
import java.util.concurrent.TimeUnit
import android.util.DisplayMetrics
import com.camachoyury.marvelwiki.BuildConfig
import com.camachoyury.marvelwiki.BuildConfig.API_URL


class RestClient<T> {


    companion object {
        fun <T> createClient(service: Class<T>): T {
            val interceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            } else interceptor.level = HttpLoggingInterceptor.Level.BASIC

            var httpClient = OkHttpClient.Builder()
                    .connectTimeout(5,TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .addInterceptor(interceptor)
                    .addInterceptor(VersionInterceptor())
                    .build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .build()
            return retrofit.create(service)

        }


       class VersionInterceptor : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val requestBuilder = original.newBuilder()
//                        x.addHeader(HEADER_PLATFORM, "android")
//                        .addHeader(HEADER_VERSION, BuildConfig.VERSION_NAME)


                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        }


    }



}
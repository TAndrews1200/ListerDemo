package com.fetch_test.listerdemo.retrofit

import com.fetch_test.listerdemo.retrofit.services.NameService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object RetrofitClient {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    private val timberLoggingInterceptor = HttpLoggingInterceptor { message ->
        Timber.tag("httpInterceptor").v(message)
    }.apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(timberLoggingInterceptor)
        .build()

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}

object NameClient {
    val nameService: NameService by lazy {
        RetrofitClient.retrofit.create(NameService::class.java)
    }
}
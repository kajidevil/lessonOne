package com.example.homework.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class HttpClient {

    fun getHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }

}
package com.example.homework.presentation.card

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework.data.model.UserResponse
import com.example.homework.data.network.API_BASE_URL
import com.example.homework.data.network.UsersApi
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CardViewModel: ViewModel() {

   fun getUsers() {
       val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
           level = HttpLoggingInterceptor.Level.BODY
       })

       val retrofit = Retrofit.Builder()
           .baseUrl(API_BASE_URL)
           .addConverterFactory(GsonConverterFactory.create())
           .client(okHttpClientBuilder.build())
           .build()

       val api: UsersApi = retrofit.create(UsersApi::class.java)
       var users: List<UserResponse> = emptyList()

       viewModelScope.launch {
           val response = api.getUsersData()

           if(response.isSuccessful){
               users = response.body()!!
               response.body()
           } else {
               response.errorBody()
           }
       }
   }


}
package com.example.homework.data.network

import com.example.homework.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    suspend fun getUsersData(): Response<List<UserResponse>>

}
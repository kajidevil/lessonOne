package com.example.homework.data.network

import com.example.homework.data.model.CommentsResponse
import com.example.homework.data.model.PostResponse
import com.example.homework.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("users")
    suspend fun getUsersData(): Response<List<UserResponse>>

    @GET("posts")
    suspend fun getPostData(): Response<List<PostResponse>>

    @GET("comments")
    suspend fun getCommentsData(): Response<List<CommentsResponse>>
}
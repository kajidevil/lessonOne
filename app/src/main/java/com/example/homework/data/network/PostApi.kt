package com.example.homework.data.network

import com.example.homework.data.model.PostResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPostData(): Response<List<PostResponse>>

}
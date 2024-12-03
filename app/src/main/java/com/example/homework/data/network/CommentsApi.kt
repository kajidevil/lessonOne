package com.example.homework.data.network

import com.example.homework.data.model.CommentsResponse
import retrofit2.Response
import retrofit2.http.GET

interface CommentsApi {

    @GET("comments")
    suspend fun getCommentsData(): Response<List<CommentsResponse>>

}
package com.example.homework.data.repository

import com.example.homework.data.model.CommentsResponse
import com.example.homework.data.model.PostResponse
import com.example.homework.data.model.UserResponse
import com.example.homework.data.network.Network.newsApi
import retrofit2.Response

class NewsRepository {
    suspend fun getUsersData(): Response<List<UserResponse>> {
        return newsApi.getUsersData()
    }

    suspend fun getPostData(): Response<List<PostResponse>> {
        return newsApi.getPostData()
    }

    suspend fun getCommentsData(): Response<List<CommentsResponse>> {
        return newsApi.getCommentsData()
    }
}
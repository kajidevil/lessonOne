package com.example.homework.presentation.card

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework.data.model.CommentsResponse
import com.example.homework.data.model.PostResponse
import com.example.homework.data.model.UserResponse
import com.example.homework.data.network.Plane
import com.example.homework.data.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import javax.inject.Inject

@HiltViewModel
class CardViewModel @Inject constructor(
    val plane: Plane,
    val newsRepository: NewsRepository,
) : ViewModel() {

    fun getUsers() {
        var users: List<UserResponse> = emptyList()
        Log.e("wqe", plane.podyomnik.toString())

        viewModelScope.launch {
            val response = newsRepository.getUsersData()
            if (response.isSuccessful) {
                users = response.body()!!
                response.body()
            } else {
                response.errorBody()
            }
        }
    }

    fun getPost() {
        var posts: List<PostResponse> = emptyList()

        viewModelScope.launch {
            val response = newsRepository.getPostData()
            if (response.isSuccessful) {
                posts = response.body()!!
                response.body()
            } else {
                response.errorBody()
            }
        }
    }

    fun getComment() {
        var comments: List<CommentsResponse> = emptyList()

        viewModelScope.launch {
            val response = newsRepository.getCommentsData()
            if (response.isSuccessful) {
                comments = response.body()!!
                response.body()
            } else {
                response.errorBody()
            }
        }
    }
}
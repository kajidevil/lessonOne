package com.example.homework.data.model

import com.google.gson.annotations.SerializedName

class CommentsResponse(
    @SerializedName("postid")
    val userid: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("body")
    val body: String,
)

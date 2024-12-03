package com.example.homework.data.model

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("userid")
    val userid: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,
)

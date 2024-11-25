package com.example.homework.data.model

import com.google.gson.annotations.SerializedName

class UserResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("address")
    val address: AddressResponse,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("website")
    val website: String,

    @SerializedName("company")
    val company: CompanyResponse,
)

class AddressResponse(
    @SerializedName("street")
    val street: String,

    @SerializedName("suite")
    val suite: String,

    @SerializedName("city")
    val city: String,

    @SerializedName("zipcode")
    val zipcode: String,

    @SerializedName("geo")
    val coordinate: CoordinateResponse,
)

class CoordinateResponse(
    @SerializedName("lat")
    val latitude: String,

    @SerializedName("lng")
    val longitude: String,
)

class CompanyResponse(
    @SerializedName("name")
    val name: String,

    @SerializedName("catchPhrase")
    val catchPhrase: String,

    @SerializedName("bs")
    val bs: String,
)
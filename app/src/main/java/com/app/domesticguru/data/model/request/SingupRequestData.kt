package com.app.domesticguru.data.model.request

import com.google.gson.annotations.SerializedName

data class SingupRequestData (
        @SerializedName("first_name") val firstName : String,
        @SerializedName("last_name") val lastName : String,
        @SerializedName("address") val address : String,
        @SerializedName("email") val email : String,
        @SerializedName("phone") val phone: String,
        @SerializedName("password") val password: String,
        @SerializedName("confirm_password") val confirm_password : String,
        @SerializedName("city") val city: String,
        @SerializedName("country") val country: String,

)
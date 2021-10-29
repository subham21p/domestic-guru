package com.app.domesticguru.data.model.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRequestData (
    @SerializedName("mobile") val mobile: String,
    @SerializedName("password") val password: String
) : Parcelable
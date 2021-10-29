package com.app.domesticguru.data.model.response.LogOutResponse

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class LogoutResponse(
    val success: Boolean,
    val message: String
) : Parcelable
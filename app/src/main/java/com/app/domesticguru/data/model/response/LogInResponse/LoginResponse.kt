package com.app.domesticguru.data.model.response.LogInResponse

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class LoginResponse(
    val success: Boolean,
    val data: LoginResponseData?,
    val message: String
) : Parcelable
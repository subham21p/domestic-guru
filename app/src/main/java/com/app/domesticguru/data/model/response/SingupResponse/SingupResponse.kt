package com.app.domesticguru.data.model.response.SingupResponse

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class SingupResponse(
        val success: Boolean,
        val data: SingupResponseData?,
        val message: String
) : Parcelable
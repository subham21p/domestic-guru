package com.app.domesticguru.data.model.response.LogInResponse

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Keep
data class LoginResponseData(
    /*val id: Int,
    @SerializedName("role_id")
    val roleId: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val email: String,
    val mobile: Long,
    @SerializedName("email_verified_at")
    val emailVerifiedAt: String,
    @SerializedName("facebook_id")
    val facebookId: String,
    @SerializedName("google_id")
    val googleId: String,
    @SerializedName("twitter_id")
    val twitterId: String,
    @SerializedName("send_offers")
    val sendOffers: Boolean,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("deleted_at")
    val deletedAt: String,
    @SerializedName("access_token")
    val accessToken: String*/
    val id: String,
    val name: String,
    val email: String,
    val mobile: Long,
    val photo: String?,
    val status: String?,
    @SerializedName("access_token")
    val accessToken: String
) : Parcelable
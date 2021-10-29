package com.app.domesticguru.data.api.service

import com.app.domesticguru.data.model.response.LogOutResponse.LogoutResponse
import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.POST

interface LogoutService {
    @POST("/api/app/vendor/logout")
    fun sendLogoutRequest(
        @Header("Authorization") accessToken : String
    ) : Call<LogoutResponse>
}
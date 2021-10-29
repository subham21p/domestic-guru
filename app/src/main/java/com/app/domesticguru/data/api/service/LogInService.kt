package com.app.domesticguru.data.api.service

import com.app.domesticguru.data.model.request.LoginRequestData
import com.app.domesticguru.data.model.response.LogInResponse.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface LogInService  {
    //  @FormUrlEncoded
    @POST("usersApp/login")
    fun sendLoginRequest(@Body data: LoginRequestData, @Query("device_token_android") device_token_android: String?) : Call<LoginResponse>

}
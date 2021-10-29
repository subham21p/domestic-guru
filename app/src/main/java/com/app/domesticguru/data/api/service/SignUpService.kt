package com.app.domesticguru.data.api.service

import com.app.domesticguru.data.model.request.SingupRequestData
import com.app.domesticguru.data.model.response.SingupResponse.SingupResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface SingupService {

    @POST("usersApp/create-account")
    fun sendSingupRequest(@Body data: SingupRequestData) : Call<SingupResponse>

}
package com.app.domesticguru.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.domesticguru.data.api.service.LogInService
import com.app.domesticguru.data.model.request.LoginRequestData
import com.app.domesticguru.data.model.response.LogInResponse.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private val loginService: LogInService) {
    private val TAG: String = LoginRepository::class.java.simpleName


    internal fun sendLoginRequest(data : LoginRequestData, device_token_android: String?) : LiveData<LoginResponse> {
        val responseData: MutableLiveData<LoginResponse> = MutableLiveData()

        val caLL: Call<LoginResponse> = loginService.sendLoginRequest(data, device_token_android)
        caLL.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d(TAG, "LoginRepository{} : onFailure() >>" +
                        " [line ${Thread.currentThread().stackTrace[2].lineNumber}] :: Error : ${t.message}"
                )
                responseData.postValue(
                        LoginResponse(
                                false, null, t.message ?: "Response Failure"
                        )
                )
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val responseBody: LoginResponse? = response.body()
                if (responseBody != null) {
                    if (responseBody.success) {
                        if (responseBody.data != null) {
                            responseData.postValue(responseBody)
                        } else {
                            responseData.postValue(
                                    LoginResponse(
                                            false, null, responseBody.message
                                    )
                            )
                        }
                    } else {
                        responseData.postValue(
                                LoginResponse(
                                        false, null, responseBody.message
                                )
                        )
                    }
                } else {
                    responseData.postValue(
                            LoginResponse(
                                    false, null, response.message()
                            )
                    )
                }
            }
        })

        return responseData
    }
}
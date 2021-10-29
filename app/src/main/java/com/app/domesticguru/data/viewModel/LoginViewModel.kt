package com.app.domesticguru.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.app.domesticguru.data.api.RetrofitInstance
import com.app.domesticguru.data.api.service.LogInService
import com.app.domesticguru.data.model.request.LoginRequestData
import com.app.domesticguru.data.model.response.LogInResponse.LoginResponse
import com.app.domesticguru.data.repository.LoginRepository
import retrofit2.Retrofit

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG: String = LoginViewModel::class.java.simpleName

    private var mRetrofit: Retrofit? = null
    private var mLoginService: LogInService? = null
    private var mLoginRepository: LoginRepository? = null
    init {
        mRetrofit = RetrofitInstance.getRetrofitInstance()
        mLoginService = RetrofitInstance.getLoginApiService(RetrofitInstance.getRetrofitInstance())
        mLoginRepository = LoginRepository(RetrofitInstance.getLoginApiService(RetrofitInstance.getRetrofitInstance()))
    }

    internal fun sendLoginRequest(data : LoginRequestData, device_token_android: String?) : LiveData<LoginResponse>? {
        return mLoginRepository?.sendLoginRequest(data, device_token_android)
    }
}
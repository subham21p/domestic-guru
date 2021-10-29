package com.app.domesticguru.data.api

import com.app.domesticguru.data.api.service.LogInService
import com.app.domesticguru.data.api.service.LogoutService
import com.app.domesticguru.data.api.service.SingupService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    private val TAG: String = RetrofitInstance::class.java.simpleName

    companion object {
        //  private const val BASE_URL: String = "http://18.222.1.130"
        //   private const val BASE_URL: String = "https://godskart.com"

        val BASE_URL = "https://www.domesticgurus.com/"
        //  val BASE_URL = "http://192.168.1.12:8000"

        // val BASE_URL = "http://192.168.1.12"

        private val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        private val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
        internal fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
        }


        internal fun getLoginApiService(mRetrofit: Retrofit): LogInService {
            return mRetrofit.create(LogInService::class.java)
        }

        internal fun getLogoutApiService(mRetrofit: Retrofit): LogoutService {
            return mRetrofit.create(LogoutService::class.java)
        }


        internal fun getSingupApiService(mRetrofit: Retrofit): SingupService {
            return mRetrofit.create(SingupService::class.java)
        }


    }


}
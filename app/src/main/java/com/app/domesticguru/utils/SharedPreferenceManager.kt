package com.app.domesticguru.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager private constructor(){
    companion object {
        private val mSharedPreference = SharedPreferenceManager()
        private lateinit var sharedPreferences: SharedPreferences

        private const val ACCESS_TOKEN_ID = "userAccessToken"
        private const val LOGIN_ID = "userLogin"
        private const val LOGIN_STATUS = "userLoginStatus"
        private  const val LOGIN_ACCOUNT_ID = "accountId"

        fun getInstance(context: Context): SharedPreferenceManager {
            if (!Companion::sharedPreferences.isInitialized) {
                synchronized(SharedPreferenceManager::class.java) {
                    if (!Companion::sharedPreferences.isInitialized) {
                        sharedPreferences = context.getSharedPreferences(context.packageName, Activity.MODE_PRIVATE)
                    }
                }
            }
            return mSharedPreference
        }
    }



    val getUserAccessToken: String? get() = sharedPreferences.getString(ACCESS_TOKEN_ID, null)
    fun saveUserAccessToken(accessToken: String){
        sharedPreferences.edit()
                .putString(ACCESS_TOKEN_ID, accessToken)
                .apply()
    }

    val isLogin: Boolean get() = sharedPreferences.getBoolean(LOGIN_ID, false)
    val loginStatus: String? get() = sharedPreferences.getString(LOGIN_STATUS, null)
    fun saveLoginStatus(isLogin: Boolean, loginStatus: String?) {
        sharedPreferences.edit()
                .putBoolean(LOGIN_ID, isLogin)
                .putString(LOGIN_STATUS, loginStatus)
                .apply()
    }

    val getAccountId: String? get() = sharedPreferences.getString(LOGIN_ACCOUNT_ID, null)
    fun saveAccountId(accountId: String){
        sharedPreferences.edit()
                .putString(LOGIN_ACCOUNT_ID, accountId)
                .apply()
    }


    fun clearAll() {
        sharedPreferences.edit().clear().apply()
    }
}
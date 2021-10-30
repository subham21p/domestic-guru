package com.app.domesticguru.ui.fragment

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.app.domesticguru.R
import com.app.domesticguru.data.model.request.LoginRequestData
import com.app.domesticguru.data.model.response.LogInResponse.LoginResponse
import com.app.domesticguru.data.model.response.LogInResponse.LoginResponseData
import com.app.domesticguru.data.viewModel.LoginViewModel
import com.app.domesticguru.databinding.FragmentLogInBinding
import com.app.domesticguru.utils.NetworkStatus
import com.app.domesticguru.utils.SharedPreferenceManager
import java.util.Observer



class LogInFragment : Fragment() {

    private lateinit var mLayout : FragmentLogInBinding
    private var tokenVar = ""
    private lateinit var mLoginViewModel: LoginViewModel
    private var isInternetConnected: Boolean = false
    private lateinit var mSharedPreferenceManager: SharedPreferenceManager



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        context?.let {
            activity?.let { it1 ->
                NetworkStatus(it).observe(it1,  {
                isInternetConnected = it
            })
            }
        }
        mSharedPreferenceManager = context?.let { SharedPreferenceManager.getInstance(it) }!!
        mLayout = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {

            System.exit(0);
        }
        mLayout.button.setOnClickListener {
           // findNavController().navigate(R.id.action_logInFragment_to_signUpFragment2)
            sendLoginRequest()
        }
        return mLayout.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    private fun sendLoginRequest() {
        mLayout.loginProgressBar.visibility = View.VISIBLE

        val mobileNo = mLayout.etEmail.text.toString()
        val password = mLayout.etPass.text.toString()

        if (isInternetConnected) {
            if (mobileNo.isNotEmpty() && password.isNotEmpty()) {
                val loginRequestData = LoginRequestData(
                        mobileNo, password
                )



                activity?.let {
                    mLoginViewModel.sendLoginRequest(loginRequestData,tokenVar)?.observe(it,  {
                        mLayout.loginProgressBar.visibility = View.VISIBLE
                        mLayout.button.isEnabled = false
                        context?.let { it1 -> ContextCompat.getColor(it1, R.color.colorBlackGray) }?.let { it2 -> mLayout.button.setBackgroundColor(it2) }

                        val loginResponse: LoginResponse? = it
                        if (loginResponse != null) {
                            if (loginResponse.success) {
                                Toast.makeText(context, loginResponse.message, Toast.LENGTH_SHORT).show()
                                val loginData: LoginResponseData? = loginResponse.data
                                if (loginData != null) {
                                    Toast.makeText(context, loginResponse.message, Toast.LENGTH_SHORT).show()
                                    Log.d(
                                            ContentValues.TAG, "Login_id !!!!!!!!!!" +
                                            " [line ${Thread.currentThread().stackTrace[2].lineNumber}] :: ${loginData.id}"
                                    )
                                    mSharedPreferenceManager.saveUserAccessToken(loginResponse.data.accessToken)
                                    mSharedPreferenceManager.saveAccountId(loginResponse.data.id)

                                    mLayout.loginProgressBar.visibility = View.GONE
                                    mLayout.button.isEnabled = true
                                    context?.let { it1 -> ContextCompat.getColor(it1, R.color.colorAccent) }?.let { it2 -> mLayout.button.setBackgroundColor(it2) }
                                    findNavController().navigate(R.id.action_logInFragment_to_signUpFragment2)

                                } else {
                                    Toast.makeText(context, loginResponse.message, Toast.LENGTH_SHORT).show()

                                    mLayout.loginProgressBar.visibility = View.GONE
                                    mLayout.button.isEnabled = true
                                    context?.let { it1 -> ContextCompat.getColor(it1, R.color.colorAccent) }?.let { it2 -> mLayout.button.setBackgroundColor(it2) }
                                }

                            } else {
                                Toast.makeText(context, getString(R.string.invalid_mobile_or_password), Toast.LENGTH_SHORT).show()

                                mLayout.loginProgressBar.visibility = View.GONE
                                mLayout.button.isEnabled = true
                                context?.let { it1 -> ContextCompat.getColor(it1, R.color.colorAccent) }?.let { it2 -> mLayout.button.setBackgroundColor(it2) }
                            }

                        } else {
                            mLayout.loginProgressBar.visibility = View.GONE
                            mLayout.button.isEnabled = true
                            context?.let { it1 -> ContextCompat.getColor(it1, R.color.colorAccent) }?.let { it2 -> mLayout.button.setBackgroundColor(it2) }
                        }
                    })
                }
            } else {
                mLayout.loginProgressBar.visibility = View.GONE
                Toast.makeText(context, getString(R.string.empty_field), Toast.LENGTH_SHORT).show()
            }
        } else {
            mLayout.loginProgressBar.visibility = View.GONE
            Toast.makeText(context, getString(R.string.no_interner_connection), Toast.LENGTH_SHORT).show()
        }

    }

}
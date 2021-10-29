package com.app.domesticguru.ui.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.app.domesticguru.R
import com.app.domesticguru.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {

    private lateinit var mLayout : FragmentSplashScreenBinding

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mLayout = DataBindingUtil.inflate(inflater, R.layout.fragment_splash_screen, container, false)
        Handler().postDelayed( Runnable {
            findNavController().navigate(R.id.action_splashScreenFragment_to_logInFragment)


          /*  if (mSharedPreferenceManager.isLogin) {
                Intent(this@SplashActivity, MainActivity::class.java).also {
                    startActivity(it)
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                }
            } else if (mSharedPreferenceManager.isLogin && mSharedPreferenceManager.loginStatus == "pending") {
                Intent(this@SplashActivity, PendingActivity::class.java).also {
                    startActivity(it)
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                }
            }
            else {
                Intent(this@SplashActivity, LoginActivity::class.java).also {
                    startActivity(it)
                    //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                }
            }*/

        }, 3000)

        mLayout.buttonHome.setOnClickListener {
            findNavController().navigate(R.id.action_splashScreenFragment_to_homeFragment)
        }

        return mLayout.root
      //  return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

/*    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplashScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}
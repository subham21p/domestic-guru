package com.app.domesticguru.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.app.domesticguru.R
import com.app.domesticguru.databinding.FragmentSignUpBinding

/*private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"*/


class SignUpFragment : Fragment() {

    private lateinit var mLayout : FragmentSignUpBinding
/*    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
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
        mLayout = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)
        mLayout.button.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_logInFragment2)
        }

        return  mLayout.root
    }

/*    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}
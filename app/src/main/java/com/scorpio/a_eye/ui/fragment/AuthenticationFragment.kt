package com.scorpio.a_eye.ui.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.databinding.DialogEditDataBinding
import com.scorpio.a_eye.databinding.FragmentAuthenticationBinding
import com.scorpio.a_eye.ui.MainActivity
import java.lang.StringBuilder

class AuthenticationFragment : BaseFragment() {

    private lateinit var binding: FragmentAuthenticationBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAuthenticationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
        initObservers()
    }

    private fun init() {
        with(binding) {
            appbar.btnBack.visibility = View.INVISIBLE
            appbar.heading.text = StringBuilder().append("Sign In")
        }
    }

    private fun initListeners() {
        with(binding) {
            //Click listener for button to change login/signup view.
            textChangeView.setOnClickListener {
                if (groupSignIn.visibility == View.VISIBLE) {
                    changeView(false)
                } else {
                    changeView(true)
                }
            }

            //Click listener to login/signup user.
            btnAuth.setOnClickListener {
                activity?.apply { if (this is MainActivity) showHideLoadingDialog(true) }

                if (groupSignIn.visibility == View.VISIBLE) {
                    with(signInEmail) {
                        if (text.trim().isEmpty()) {
                            error = "Enter your email"
                            requestFocus()
                            activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }
                            return@setOnClickListener
                        }
                    }
                    with(signInPassword) {
                        if (text.trim().isEmpty()) {
                            error = "Enter your password"
                            requestFocus()
                            activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }
                            return@setOnClickListener
                        }
                    }

                    appViewModel.signInUser(signInEmail.text.toString(), signInPassword.text.toString())
                } else {
                    var canRegister = true
                    checkEmpty(signUpName, "Enter person name") {
                        canRegister = false
                    }
                    checkEmpty(signUpAge, "Enter person age") {
                        canRegister = false
                    }
                    checkEmpty(signUpGuideName, "Enter your name") {
                        canRegister = false
                    }
                    checkEmpty(signUpGuidePhone, "Enter your phone") {
                        canRegister = false
                    }
                    checkEmpty(signUpEmail, "Enter your email") {
                        canRegister = false
                    }
                    checkEmpty(signUpPassword, "Enter your password") {
                        canRegister = false
                    }
                    checkEmpty(signUpConfirmPassword, "Confirm your password") {
                        canRegister = false
                    }

                    val gender = if (genderRadioGroup.checkedRadioButtonId == male.id) {
                        "male"
                    } else {
                        "female"
                    }

                    if (signUpPassword.text.toString().length < 6) {
                        canRegister = false
                        activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }
                        showToast("Password must be greater than 6 characters.")
                        return@setOnClickListener
                    }

                    if (signUpPassword.text.toString() != signUpConfirmPassword.text.toString()) {
                        canRegister = false
                        activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }
                        showToast("Password and Confirm Password must be same.")
                        return@setOnClickListener
                    }

                    if (canRegister) {
                        appViewModel.registerUser(
                            signUpName.text.toString(),
                            signUpAge.text.toString(),
                            gender,
                            signUpGuideName.text.toString(),
                            signUpGuidePhone.text.toString(),
                            signUpEmail.text.toString(),
                            signUpPassword.text.toString()
                        )
                    } else {
                        activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }
                    }
                }
            }
        }
    }

    private fun initObservers() {
        appViewModel.showAuthenticationStatus.observe(viewLifecycleOwner) {
            when (it) {
                0 -> {
                    showToast("Logged in Successfully.")
                    findNavController().popBackStack()
                }
                1 -> {
                    showToast("Login Failed. Some error occurred. ")
                }
                2 -> {
                    showToast("Registered Successfully.")
                    findNavController().popBackStack()
                }
                3 -> {
                    showToast("Registration Failed. Some error occurred. ")
                }
            }
            if (it != null)
                activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }

            appViewModel.showAuthenticationStatus.postValue(null)
        }
    }

    private fun checkEmpty(editText: EditText, errorMessage: String, callback: () -> Unit) {
        with(editText) {
            if (text.trim().isEmpty()) {
                error = errorMessage
                requestFocus()
                callback()
            }
        }
    }

    private fun changeView(setSignInView: Boolean) {
        Toast.makeText(requireContext(), "$setSignInView", Toast.LENGTH_SHORT).show()
        with(binding) {
            if (setSignInView) {
                appbar.heading.text = StringBuilder().append("Sign In")
                header.text = StringBuilder().append("Welcome").append("\n").append("to A-Eye").toString()
                textChangeView.text = StringBuilder().append("Create new account")

                btnAuth.text = StringBuilder().append("Sign In")
                groupSignIn.visibility = View.VISIBLE
                groupSignUp.visibility = View.GONE
            } else {
                appbar.heading.text = StringBuilder().append("Sign Up")
                header.text = StringBuilder().append("Create").append("\n").append("Account").toString()
                textChangeView.text = StringBuilder().append("Already have an account?")

                btnAuth.text = StringBuilder().append("Create Account")
                groupSignUp.visibility = View.VISIBLE
                groupSignIn.visibility = View.GONE
            }
        }
    }

}
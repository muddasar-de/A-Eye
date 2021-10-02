package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {

    private lateinit var binding: FragmentAboutUsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAboutUsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
    }

    private fun init() {
        binding.appbar.heading.text = "About Us"
    }

    private fun initListeners() {
        binding.appbar.btnBack.setOnClickListener { findNavController().popBackStack() }
        binding.headingAboutUs.setOnClickListener { setAboutUsText() }
        binding.headingTermsConditions.setOnClickListener { setTermsAndConditionsText() }
        binding.headingPrivacyPolicy.setOnClickListener { setPrivacyPolicyText() }
    }

    private fun setAboutUsText(){
        binding.txtTermsConditions.visibility = View.GONE
        binding.txtPrivacyPolicy.visibility = View.GONE
        binding.txtAboutUs.visibility = View.VISIBLE
    }

    private fun setTermsAndConditionsText() {
        binding.txtAboutUs.visibility = View.GONE
        binding.txtPrivacyPolicy.visibility = View.GONE
        binding.txtTermsConditions.visibility = View.VISIBLE
    }

    private fun setPrivacyPolicyText() {
        binding.txtTermsConditions.visibility = View.GONE
        binding.txtAboutUs.visibility = View.GONE
        binding.txtPrivacyPolicy.visibility = View.VISIBLE
    }

}
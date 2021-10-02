package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentSettingsBinding
import java.lang.StringBuilder

class SettingsFragment : BaseFragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()

    }

    private fun init() {
        with(binding) {
            appbar.heading.text = StringBuilder().append("Setting")
        }
    }

    private fun initListeners() {
        with(binding) {
            appbar.btnBack.setOnClickListener { findNavController().popBackStack() }

            layoutAccount.setOnClickListener {
                navigateToFragment(R.id.action_settingsFragment_to_accountSettingFragment, R.id.accountSettingFragment)
            }
            layoutSystem.setOnClickListener {
                navigateToFragment(R.id.action_settingsFragment_to_systemSettingFragment, R.id.systemSettingFragment)
            }
        }
    }
}
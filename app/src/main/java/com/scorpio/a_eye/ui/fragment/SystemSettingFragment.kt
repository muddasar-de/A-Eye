package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.databinding.FragmentSystemSettingBinding
import com.scorpio.a_eye.ui.fragment.BaseFragment

class SystemSettingFragment : BaseFragment() {
    private lateinit var binding: FragmentSystemSettingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSystemSettingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        initListeners()
    }


    private fun init() {
        with(binding) {
            appbar.heading.text = StringBuilder().append("System Setting")
        }
    }

    private fun initListeners() {
        with(binding) {
            appbar.btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }
}
package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentAccountSettingBinding
import com.scorpio.a_eye.databinding.FragmentCapturedImageViewBinding


class capturedImageViewFragment : BaseFragment() {

    private lateinit var binding: FragmentCapturedImageViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCapturedImageViewBinding.inflate(layoutInflater, container, false)
        return binding.root
    }



}
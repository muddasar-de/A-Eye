package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentAccountSettingBinding
import com.scorpio.a_eye.databinding.FragmentCapturedImageViewBinding
import java.io.File
import java.net.URI
import android.graphics.BitmapFactory

import android.graphics.Bitmap
import android.net.Uri
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide


class capturedImageViewFragment : BaseFragment() {

    private lateinit var binding: FragmentCapturedImageViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCapturedImageViewBinding.inflate(layoutInflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = this.arguments
        val photoPath = args?.get("PhotoPath")
        context?.let {
            Glide.with(it)
                .load(photoPath)
                .into(binding.capturedImageView)
        }
        init()
        initListeners()
    }
private fun init() {
    binding.appbar.heading.text = "Captured Image"
}

    private fun initListeners() {
        binding.appbar.btnBack.setOnClickListener { findNavController().navigate(R.id.nav_graph)
        }

    }

}




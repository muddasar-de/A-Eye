package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentDemoBinding
import com.scorpio.a_eye.ui.MainActivity
import android.webkit.WebChromeClient

import android.webkit.WebSettings

import android.webkit.WebView

import android.webkit.WebViewClient


class DemoFragment : BaseFragment() {

    private lateinit var binding: FragmentDemoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDemoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
    }

    private fun init() {
        binding.appbar.heading.text = "Demo"

        with(binding.webView) {
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    return false
                }
            }

            settings.pluginState = WebSettings.PluginState.ON
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true
            settings.setAppCacheEnabled(true)
            setInitialScale(1)
            settings.loadWithOverviewMode = true
            settings.useWideViewPort = true

            loadUrl("https://www.youtube.com/watch?v=tO2F9tBJCs4")
        }


    }

    private fun initListeners() {
        binding.appbar.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}
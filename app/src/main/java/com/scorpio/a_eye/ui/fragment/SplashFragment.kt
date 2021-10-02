package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentSplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }

    private fun init(){
        CoroutineScope(IO).launch {
            delay(3000)
            navigateToFragment(R.id.action_splashFragment_to_mainFragment, R.id.mainFragment)
        }
    }

}
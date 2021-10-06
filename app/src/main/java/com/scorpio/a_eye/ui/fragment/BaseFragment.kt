package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.ui.MainActivity
import com.scorpio.a_eye.viewmodel.AppViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

open class BaseFragment : Fragment() {

    lateinit var appViewModel: AppViewModel

    private val navOptions = NavOptions.Builder()
        .setEnterAnim(android.R.anim.fade_in)
        .setPopEnterAnim(android.R.anim.fade_in).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.apply {
            if (this is MainActivity) appViewModel =
                ViewModelProvider(this)[AppViewModel::class.java]
        }
    }

    fun navigateToFragment(actionId: Int?, fragmentId: Int, bundle: Bundle = bundleOf()) {
        CoroutineScope(Main).launch {
            findNavController().apply {
                if (currentDestination?.id != fragmentId) {
                    try {
                        if (actionId != null)
                            navigate(actionId, bundle, navOptions)
                        else
                            navigate(fragmentId, bundle, navOptions)
                    } catch (e: Exception) {
                        navigate(fragmentId, bundle, navOptions)
                    }
                }
            }
        }
    }

    fun showToast(text: String) {
        CoroutineScope(Main).launch {
            try {
                Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
            } catch (e: java.lang.Exception) {

            }
        }
    }

}
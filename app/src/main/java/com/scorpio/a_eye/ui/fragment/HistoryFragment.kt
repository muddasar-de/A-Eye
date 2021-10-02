package com.scorpio.a_eye.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.FragmentHistoryBinding
import com.scorpio.a_eye.utils.Constants
import java.lang.StringBuilder

class HistoryFragment : BaseFragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
    }

    private fun init() {
        with(binding) {
            appbar.heading.text = StringBuilder().append("History")
        }
    }

    private fun initListeners() {
        with(binding) {
            appbar.btnBack.setOnClickListener { findNavController().popBackStack() }

            layoutFaces.setOnClickListener {
                navigateToFragment(R.id.action_historyFragment_to_historyDetailsFragment, R.id.historyDetailsFragment, bundleOf(Pair("type", Constants.FACES_CONSTANTS)))
            }

            layoutCurrency.setOnClickListener {
                navigateToFragment(R.id.action_historyFragment_to_historyDetailsFragment, R.id.historyDetailsFragment, bundleOf(Pair("type", Constants.CURRENCY_CONSTANTS)))

            }
        }
    }
}
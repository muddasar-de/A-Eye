package com.scorpio.a_eye.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.scorpio.a_eye.adapters.HistoryDetailsAdapter
import com.scorpio.a_eye.databinding.FragmentHistoryDetailsBinding
import com.scorpio.a_eye.ui.FaceTrainActivity
import com.scorpio.a_eye.utils.Constants

class HistoryDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentHistoryDetailsBinding

    private var type: Int = -1

    private val historyDetailsAdapter by lazy { HistoryDetailsAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHistoryDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        type = when (arguments?.getString("type")) {
            Constants.FACES_CONSTANTS -> 0
            Constants.CURRENCY_CONSTANTS -> 1
            else -> 0
        }
        init()
        initListeners()
        initObservers()
    }

    private fun init() {
        with(binding) {
            appbar.heading.text = if (type == 0) "Faces" else "Currency"

            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
            recyclerView.adapter = historyDetailsAdapter

            historyDetailsAdapter.clickListener = object : HistoryDetailsAdapter.ClickListener {
                override fun onClickListener() {
                    startActivity(Intent(requireContext(), FaceTrainActivity::class.java).putExtra("guideEmail", appViewModel.currentUser.value?.guideEmail))
                }
            }
        }
    }

    private fun initListeners() {
        with(binding) {
            appbar.btnBack.setOnClickListener { findNavController().popBackStack() }
        }
    }

    private fun initObservers() {
        appViewModel.currentUser.observe(viewLifecycleOwner) {
            when (type) {
                0 -> {
                    if (it.faces.isNotEmpty()) {
                        historyDetailsAdapter.setData(it.faces)
                        binding.groupNoItems.visibility = View.GONE
                    } else {
                        startActivity(
                            Intent(requireActivity(), FaceTrainActivity::class.java)
                                .putExtra("guideEmail", it.guideEmail)
                        )
                        binding.groupNoItems.visibility = View.VISIBLE
                        binding.noItemHeading.text = "No faces found."
                    }
                }
                1 -> {
                    if (it.currencies.isNotEmpty()) {
                        historyDetailsAdapter.setData(it.currencies)
                        binding.groupNoItems.visibility = View.GONE
                    } else {
                        binding.groupNoItems.visibility = View.VISIBLE
                        binding.noItemHeading.text = "No currencies found."
                    }
                }
            }
        }
    }
}
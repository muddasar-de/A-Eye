package com.scorpio.a_eye.ui.fragment

import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.scorpio.a_eye.R
import com.scorpio.a_eye.databinding.DialogEditDataBinding
import com.scorpio.a_eye.databinding.FragmentAccountSettingBinding
import com.scorpio.a_eye.ui.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AccountSettingFragment : BaseFragment() {

    private lateinit var binding: FragmentAccountSettingBinding

    private val editDialog by lazy { Dialog(requireContext()) }
    private val editDialogBinding by lazy { DialogEditDataBinding.inflate(layoutInflater) }

    private var guideHash: HashMap<String, Any> = hashMapOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAccountSettingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initListeners()
        initObservers()
    }

    private fun init() {
        with(binding) {
            appbar.heading.text = StringBuilder().append("Setting")
        }
    }

    private fun initListeners() {
        with(binding) {
            appbar.btnBack.setOnClickListener { findNavController().popBackStack() }

            editImage.setOnClickListener { pickUserImage() }
            editName.setOnClickListener {
                showEditDialog("Change user name.", false) {
                    guideHash["userName"] = it
                    appViewModel.updateData(guideHash)
                }
            }
            editAge.setOnClickListener {
                showEditDialog("Change user age.", true) {
                    guideHash["userAge"] = it
                    appViewModel.updateData(guideHash)
                }
            }
            editGender.setOnClickListener {
                showEditDialog("Change user gender.", false) {
                    guideHash["userGender"] = it
                    appViewModel.updateData(guideHash)
                }
            }
            editGuideName.setOnClickListener {
                showEditDialog("Change your name.", false) {
                    guideHash["guideName"] = it
                    appViewModel.updateData(guideHash)
                }
            }
            editPhone.setOnClickListener {
                showEditDialog("Change phone name.", true) {
                    guideHash["guidePhone"] = it
                    appViewModel.updateData(guideHash)
                }
            }
        }
    }

    private fun initObservers() {
        appViewModel.currentUser.observe(viewLifecycleOwner) { guide ->
            with(binding) {
                Glide.with(requireContext()).load(guide.guidePhoto).placeholder(R.drawable.ic_user_placeholder).into(userImage)
                txtName.text = guide.userName
                txtAge.text = guide.userAge.toString()
                txtGender.text = guide.userGender
                txtGuideName.text = guide.guideName
                txtPhone.text = guide.guidePhone
            }

            guideHash = hashMapOf(
                "userId" to "${guide.userId}",
                "guidePhoto" to "${guide.guidePhoto}",
                "guideName" to "${guide.guideName}",
                "guidePhone" to "${guide.guidePhone}",
                "userName" to guide.userName,
                "userAge" to "${guide.userAge}",
                "userGender" to "${guide.userGender}",
                "faces" to guide.faces,
                "currencies" to guide.currencies
            )
        }
        appViewModel.showAuthenticationStatus.observe(viewLifecycleOwner) {
            when (it) {
                5 -> {
                    showToast("Data Edited Successfully.")
                }
                6 -> {
                    showToast("Unable to edit data. Please try again.")
                }
            }
            activity?.apply { if (this is MainActivity) showHideLoadingDialog(false) }
            appViewModel.showAuthenticationStatus.postValue(0)
        }
    }

    private fun pickUserImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, false)
        intent.action = Intent.ACTION_GET_CONTENT

        Permissions.check(requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE, null, object : PermissionHandler() {
            override fun onGranted() {
                registerForActivityResult.launch(intent)
            }
        })
    }

    private fun showEditDialog(heading: String, showShowNumber: Boolean, callback: (String) -> Unit) {
        editDialog.setContentView(editDialogBinding.root)
        editDialog.setCancelable(false)

        with(editDialogBinding) {
            this.heading.text = heading

            if (showShowNumber) {
                editData.inputType = InputType.TYPE_CLASS_PHONE
                editData.invalidate()
            } else {
                editData.inputType = InputType.TYPE_CLASS_TEXT
                editData.invalidate()
            }

            btnCancel.setOnClickListener {
                editData.text.clear()
                editDialog.dismiss()
            }
            btnUpdate.setOnClickListener {
                if (editData.text.isEmpty()) {
                    editData.error = "Enter text here."
                    editData.requestFocus()
                    return@setOnClickListener
                }

                CoroutineScope(Main).launch {
                    activity?.apply { if (this is MainActivity) showHideLoadingDialog(true) }

                    delay(200)
                    callback(editData.text.toString())
                    editData.text.clear()
                    editDialog.dismiss()
                }

            }
        }

        with(editDialog.window) {
            this?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
            this?.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), android.R.color.transparent))
        }
        editDialog.show()
    }

    private val registerForActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                it.data?.data.let { uri ->
                    if (uri != null) {
                        CoroutineScope(Main).launch {
                            activity?.apply { if (this is MainActivity) showHideLoadingDialog(true) }

                            delay(200)
                            Glide.with(requireContext()).load(uri).into(binding.userImage)
                            appViewModel.uploadImageToDatabase(guideHash, uri)
                        }
                    }
                }
            } else {
                showToast("No Image Found.")
            }
        }
}
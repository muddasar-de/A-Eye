package com.scorpio.a_eye.ui.fragment

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.Dialog
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.scorpio.a_eye.R
import com.scorpio.a_eye.adapters.NotifierAdapter
import com.scorpio.a_eye.alarmmanager.AlarmBroadcast
import com.scorpio.a_eye.database.Alarm
import com.scorpio.a_eye.database.AlarmDatebase
import com.scorpio.a_eye.databinding.DialogSetAlarmBinding
import com.scorpio.a_eye.databinding.FragmentNotifierAlarmBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.random.Random


class NotifierAlarmFragment : BaseFragment() {

    private lateinit var binding: FragmentNotifierAlarmBinding

    private val setDialog: Dialog by lazy { Dialog(requireContext()) }
    private val setDialogBinding: DialogSetAlarmBinding by lazy { DialogSetAlarmBinding.inflate(layoutInflater) }

    private val notifierAdapter: NotifierAdapter by lazy { NotifierAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentNotifierAlarmBinding.inflate(layoutInflater)
        init()
        initListeners()
        return binding.root
    }

    private fun init() {
        with(binding.appbar) {
            heading.text = "Notifier"
            btnBack.setOnClickListener { findNavController().popBackStack() }
        }

        setupRecyclerview()

        AlarmDatebase.getDatabase(requireContext())?.alarmDao()?.getAll()?.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.noAlarms.visibility = View.VISIBLE
                binding.alarmsRv.visibility = View.GONE
            } else {
                binding.noAlarms.visibility = View.GONE
                binding.alarmsRv.visibility = View.VISIBLE

                notifierAdapter.setData(it)
            }
        }
    }

    private fun initListeners() {
        binding.btnAddAlarm.setOnClickListener {
            showAlarmDialog()
        }
    }

    private fun setupRecyclerview() {
        with(binding) {
            alarmsRv.layoutManager = LinearLayoutManager(requireContext())
            alarmsRv.adapter = notifierAdapter

            notifierAdapter.clickListener = object : NotifierAdapter.ClickListener {
                override fun onLongClickListener(pos: Int, alarm: Alarm) {
                    showDeleteDialog(pos, alarm)
                }
            }
        }
    }

    private fun showDeleteDialog(pos: Int, alarm: Alarm) {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setTitle("Delete!")
        dialog.setMessage("Are you sure to delete this alarm?")
        dialog.setPositiveButton("Delete") { _, _ ->
            CoroutineScope(Dispatchers.IO).launch {
                AlarmDatebase.getDatabase(requireContext())?.alarmDao()?.delete(alarm)
                withContext(Dispatchers.Main) {
                    Toast.makeText(requireContext(), "Alarm Deleted Successfully.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        dialog.setNegativeButton("Cancel") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        dialog.show()
    }

    private fun showAlarmDialog() {
        setDialog.setContentView(setDialogBinding.root)
        setDialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        with(setDialogBinding) {

            btnSet.setOnClickListener {
                if (alarmLabel.text.trim().isEmpty()) {
                    alarmLabel.error = "Enter notification message"
                    alarmLabel.requestFocus()
                    return@setOnClickListener
                }
                setAlarm(alarmLabel.text.trim().toString())
            }

            btnCancel.setOnClickListener { setDialog.dismiss() }

            monday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    monday.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    return@setOnClickListener
                }
                it.isSelected = true
                monday.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            tuesday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    tuesday.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    return@setOnClickListener
                }
                it.isSelected = true
                tuesday.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            wednesday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    wednesday.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    return@setOnClickListener
                }
                it.isSelected = true
                wednesday.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            thursday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    thursday.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    return@setOnClickListener
                }
                it.isSelected = true
                thursday.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            friday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    friday.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    return@setOnClickListener
                }
                it.isSelected = true
                friday.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            saturday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    saturday.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                    return@setOnClickListener
                }
                it.isSelected = true
                saturday.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }
            sunday.setOnClickListener {
                if (it.isSelected) {
                    it.isSelected = false
                    return@setOnClickListener
                }
                it.isSelected = true
            }
        }

        setDialog.show()
    }

    private fun setAlarm(message: String) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, setDialogBinding.timePicker.hour)
        calendar.set(Calendar.MINUTE, setDialogBinding.timePicker.minute)
        calendar.set(Calendar.SECOND, 0)
        if (calendar.timeInMillis < Calendar.getInstance().timeInMillis) {
            calendar.add(Calendar.DATE, 1)
        }

        val alarmId = Random.nextInt()
        val alarm = Alarm(
            0, setDialogBinding.timePicker.hour.toString(),
            setDialogBinding.timePicker.hour.toString(),
            setDialogBinding.timePicker.minute.toString(),
            message,
            setDialogBinding.monday.isSelected.toString(),
            setDialogBinding.tuesday.isSelected.toString(),
            setDialogBinding.wednesday.isSelected.toString(),
            setDialogBinding.thursday.isSelected.toString(),
            setDialogBinding.friday.isSelected.toString(),
            setDialogBinding.saturday.isSelected.toString(),
            setDialogBinding.sunday.isSelected.toString(),
            null, null, null, alarmId.toString()
        )

        CoroutineScope(Dispatchers.IO).launch { AlarmDatebase.getDatabase(requireContext())?.alarmDao()?.insertAll(alarm) }

        //getting the alarm manager
        val am = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager

        //creating a new intent specifying the broadcast receiver
        val i = Intent(requireContext(), AlarmBroadcast::class.java)
        i.putExtra("alarmId", alarmId)
        //creating a pending intent using the intent
        val pi =
            PendingIntent.getBroadcast(requireContext(), alarmId, i, PendingIntent.FLAG_UPDATE_CURRENT)

        //  , AlarmManager.INTERVAL_DAY
        //setting the repeating alarm that will be fired every day

        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pi)

        if (setDialog.isShowing)
            setDialog.dismiss()
    }
}
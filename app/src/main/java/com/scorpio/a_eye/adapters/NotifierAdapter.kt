package com.scorpio.a_eye.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scorpio.a_eye.database.Alarm
import com.scorpio.a_eye.databinding.LayoutNotifierItemBinding

class NotifierAdapter : RecyclerView.Adapter<NotifierAdapter.MyViewHolder>() {

    private var list: MutableList<Alarm> = mutableListOf()

    var clickListener: ClickListener ?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutNotifierItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            binding.alarmLabel.text = item.label
            binding.alarmTime.text = "${item.hour} : ${item.min}"
            binding.monday.isSelected = item.mon == "true"
            binding.tuesday.isSelected = item.tues == "true"
            binding.wednesday.isSelected = item.wed == "true"
            binding.thursday.isSelected = item.thurs == "true"
            binding.friday.isSelected = item.fri == "true"
            binding.saturday.isSelected = item.sat == "true"
            binding.sunday.isSelected = item.sun == "true"

            binding.root.setOnLongClickListener {
                clickListener?.onLongClickListener(position, item)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(tempList: MutableList<Alarm>) {
        list = tempList
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: LayoutNotifierItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface ClickListener {
        fun onLongClickListener(pos: Int, alarm: Alarm)
    }
}
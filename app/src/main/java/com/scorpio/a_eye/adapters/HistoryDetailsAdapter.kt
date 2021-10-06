package com.scorpio.a_eye.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scorpio.a_eye.databinding.LayoutHistoryDetailsItemBinding

class HistoryDetailsAdapter : RecyclerView.Adapter<HistoryDetailsAdapter.MyViewHolder>() {

    private var list: List<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutHistoryDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            Glide.with(itemView.context).load(list[position]).into(binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(tempList: List<String>) {
        list = tempList
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: LayoutHistoryDetailsItemBinding) : RecyclerView.ViewHolder(binding.root)
}
package com.scorpio.a_eye.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.scorpio.a_eye.databinding.LayoutHistoryDetailsItemBinding
import com.scorpio.a_eye.ui.FaceTrainActivity

class HistoryDetailsAdapter : RecyclerView.Adapter<HistoryDetailsAdapter.MyViewHolder>() {

    private var list: ArrayList<String> = arrayListOf()

    var clickListener: ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutHistoryDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {
            if (position == 0) {
                binding.imageView.visibility = View.GONE
                binding.imageViewAdd.visibility = View.VISIBLE
                binding.root.setOnClickListener {
                    clickListener?.onClickListener()
                }
            } else {
                binding.imageView.visibility = View.VISIBLE
                binding.imageViewAdd.visibility = View.GONE
                Glide.with(itemView.context).load(list[position]).into(binding.imageView)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(tempList: List<String>) {
        list.clear()
        list.add("")
        list.addAll(tempList)
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: LayoutHistoryDetailsItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface ClickListener {
        fun onClickListener()
    }
}
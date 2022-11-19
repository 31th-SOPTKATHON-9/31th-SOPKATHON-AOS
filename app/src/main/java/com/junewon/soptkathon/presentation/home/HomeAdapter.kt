package com.junewon.soptkathon.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ItemHomehabitsBinding

class HomeAdapter (context : Context): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private val inflater by lazy {LayoutInflater.from(context)}
    private var list: List<HabitData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomehabitsBinding.inflate(inflater, parent,false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setRepoList(repoList: List<HabitData>){
        this.list = repoList.toList()
        notifyDataSetChanged()
    }

    class HomeViewHolder(
        private val binding: ItemHomehabitsBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HabitData) {
            binding.cvHomeHabit1.setText(data.habit1)
            binding.cvHomeHabit2.setText(data.habit2)
            binding.cvHomeHabit3.setText(data.habit3)
        }
    }
}

package com.junewon.soptkathon.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
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
            binding.tvHomeHabit1title.text = data.habit1title
            binding.tvHomeHabit1desc.text = data.habit1desc
            binding.tvHomeHabit2title.text = data.habit2title
            binding.tvHomeHabit2desc.text = data.habit2desc
            binding.tvHomeHabit3title.text = data.habit3title
            binding.tvHomeHabit3desc.text = data.habit3desc

        }
    }
}

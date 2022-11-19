package com.junewon.soptkathon.presentation.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.junewon.soptkathon.data.model.response.Star
import com.junewon.soptkathon.databinding.ItemCelebBinding
import com.junewon.soptkathon.presentation.home.HomeActivity

class SearchStarAdapter(context: Context) : RecyclerView.Adapter<SearchStarAdapter.SearchCelebViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var stars: List<Star> = emptyList()
    private var starsImg : List<String> = emptyList()
    private var isNetWork = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCelebViewHolder {
        val binding = ItemCelebBinding.inflate(inflater, parent, false)
        return SearchCelebViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchCelebViewHolder, position: Int)
    {
        if (!isNetWork) holder.onBind(starsImg[position],stars[position])
        else{
            if (position == 0)  holder.onBind(starsImg[position],stars[position])
        }
    }

    override fun getItemCount(): Int {
        return stars.size
    }

    fun setStars(isNetWork: Boolean = false, starsImg: List<String>, Stars: List<Star>) {
        this.stars = Stars.toList()
        this.isNetWork = isNetWork
        this.starsImg = starsImg.toList()
        notifyDataSetChanged()
    }

    class SearchCelebViewHolder(private val binding: ItemCelebBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(dataImg: String, data: Star) {
            binding.ivSearchCelebProfile.load(dataImg)
            binding.tvSearchCelebTitle.text = data.title
            binding.tvSearchCelebHabit1.text = data.habits[0].title
            binding.tvSearchCelebHabit2.text = data.habits[1].title
            binding.tvSearchCelebHabit3.text = data.habits[2].title
        }
    }
}

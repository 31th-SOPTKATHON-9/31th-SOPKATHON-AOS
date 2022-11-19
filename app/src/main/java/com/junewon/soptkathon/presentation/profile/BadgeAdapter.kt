package com.junewon.soptkathon.presentation.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.junewon.soptkathon.databinding.ItemBadgeBinding
import java.text.Bidi

class BadgeAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var badgeList: List<Badge> = emptyList()

    class BadgeViewHolder(
        private var binding: ItemBadgeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Badge) {
            if (!data.isLocked) {
                binding.ivBadge.load(data.image){
                    transformations(RoundedCornersTransformation(28f))
                    crossfade(true)
                }
                binding.ivBadge.setImageResource(data.image)
            }
            binding.tvBadge.text = data.name
            binding.tvLevel.text = data.level

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BadgeViewHolder(ItemBadgeBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BadgeViewHolder -> holder.onBind(badgeList[position])
            else -> throw IllegalArgumentException("on BadgeViewHolder")
        }
    }

    override fun getItemCount() = badgeList.size

    fun setBadgeList(badgeList: List<Badge>){
        this.badgeList = badgeList.toList()
        notifyDataSetChanged()
    }
}

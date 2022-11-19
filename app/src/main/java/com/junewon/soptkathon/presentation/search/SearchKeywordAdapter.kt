package com.junewon.soptkathon.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junewon.soptkathon.databinding.ItemPopularKeywordBinding

class SearchKeywordAdapter(context: Context) : RecyclerView.Adapter<SearchKeywordAdapter.SearchKeywordViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var keyWordList: List<KeyWordData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchKeywordViewHolder {
        val binding = ItemPopularKeywordBinding.inflate(inflater, parent, false)
        return SearchKeywordViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchKeywordViewHolder, position: Int) {
        holder.onBind(keyWordList[position])
    }

    override fun getItemCount(): Int {
        return keyWordList.size
    }

    fun setKeywordList(keywordList: List<KeyWordData>) {
        this.keyWordList = keywordList.toList()
        notifyDataSetChanged()
    }

    class SearchKeywordViewHolder(private val binding: ItemPopularKeywordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: KeyWordData) {
            binding.btnSearchKeyword.text = data.keyWord
        }
    }
}

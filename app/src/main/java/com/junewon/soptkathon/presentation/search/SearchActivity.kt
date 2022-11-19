package com.junewon.soptkathon.presentation.search

import android.os.Bundle
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ActivitySearchBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : BindingActivity<ActivitySearchBinding>(R.layout.activity_search) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // do something
    }
}

package com.junewon.soptkathon.presentation.home

import android.os.Bundle
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ActivityHomeBinding
import com.junewon.soptkathon.presentation.profile.BadgeBottomSheetDialog
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // do something..
        binding.tvHome.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        BadgeBottomSheetDialog().show(supportFragmentManager, "tag")
    }
}

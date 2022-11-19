package com.junewon.soptkathon.presentation.profile

import android.os.Bundle
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ActivityProfileBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : BindingActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // do something
    }
}

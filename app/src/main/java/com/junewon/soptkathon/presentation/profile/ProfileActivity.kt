package com.junewon.soptkathon.presentation.profile

import android.os.Bundle
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ActivityProfileBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : BindingActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    private val mockBadgeList= listOf<Badge>(
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = true
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.3",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = true
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = true
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.2",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = true
        ),
        Badge(
            image = R.drawable.ic_son,
            name = "Son",
            level = "Lv.1",
            isLocked = true
        ),


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = BadgeAdapter(this)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = adapter
        adapter.setBadgeList(mockBadgeList)
    }
}

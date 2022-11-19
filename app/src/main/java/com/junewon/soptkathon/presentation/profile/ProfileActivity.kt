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
            image = R.drawable.ic_lv1,
            name = "케빈 크루즈",
            level = "Lv.1",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_lv3,
            name = "워렌 버핏",
            level = "Lv.3",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_lv2,
            name = "버락 오바마",
            level = "Lv.2",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_lv2,
            name = "파멜라 퍼거슨",
            level = "Lv.1",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_lock,
            name = "이지수",
            level = "Lv.0",
            isLocked = true
        ),
        Badge(
            image = R.drawable.ic_lv3,
            name = "다카하시 사카에",
            level = "Lv.3",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_lock,
            name = "김연아",
            level = "Lv.1",
            isLocked = true
        ),
        Badge(
            image = R.drawable.ic_lv1,
            name = "오프라 원프리",
            level = "Lv.1",
            isLocked = false
        ),
        Badge(
            image = R.drawable.ic_lv1,
            name = "서동주",
            level = "Lv.0",
            isLocked = false
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
    private fun showBottomSheet() {
        BadgeBottomSheetDialog().show(supportFragmentManager, "tag")
    }
}

package com.junewon.soptkathon.presentation.profile

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.junewon.soptkathon.R
import com.junewon.soptkathon.data.service.SpangService
import com.junewon.soptkathon.databinding.ActivityProfileBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import com.junewon.soptkathon.util.withArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ProfileActivity : BindingActivity<ActivityProfileBinding>(R.layout.activity_profile) {
    @Inject
    lateinit var service: SpangService
    private val mockBadgeList = listOf<Badge>(
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
        )
    )

    fun fetchProgressBar() {
        lifecycleScope.launch {
            runCatching { service.getProgressBar() }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = BadgeAdapter(this, ::showBottomSheet)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = adapter
        adapter.setBadgeList(mockBadgeList)
    }

    private fun showBottomSheet(position: Int) {
        BadgeBottomSheetDialog().withArgs {
            putParcelable(BADGE, mockBadgeList[position])
        }.show(supportFragmentManager, "tag")
    }

    companion object {
        const val BADGE = "Badge_Badge"
    }
}

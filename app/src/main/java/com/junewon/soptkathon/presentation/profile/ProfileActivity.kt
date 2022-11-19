package com.junewon.soptkathon.presentation.profile

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
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
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeTextColor()
        val adapter = BadgeAdapter(this, ::showBottomSheet)
        binding.rvProfile.setHasFixedSize(true)
        binding.rvProfile.adapter = adapter
        adapter.setBadgeList(mockBadgeList)
        fetchProgressBar()
    }

    private fun changeTextColor() {
        val txt = binding.tvHabitCount.text
        val spannableString = SpannableString(txt)
        val start = 5
        val end = 6
        spannableString.setSpan(
            ForegroundColorSpan(Color.parseColor("#24FF00")),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        binding.tvHabitCount.text = spannableString
    }

    private fun fetchProgressBar() {
        lifecycleScope.launch {
            runCatching { service.getProgressBar() }
                .onSuccess {
                    binding.progressBar.progress = it.progress
                    binding.tvWeekPercent.text = "${it.progress}/100"
                    val tmp = binding.tvHabitCount.text
                    binding.tvHabitCount.text = tmp.substring(0, 5) + it.count.toString() + tmp.substring(6)
                    changeTextColor()
                }
                .onFailure { }
        }
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

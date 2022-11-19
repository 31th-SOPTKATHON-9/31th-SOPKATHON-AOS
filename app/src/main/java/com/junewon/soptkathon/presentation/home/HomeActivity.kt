package com.junewon.soptkathon.presentation.home

import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.junewon.soptkathon.R
import com.junewon.soptkathon.data.service.SpangService
import com.junewon.soptkathon.databinding.ActivityHomeBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    @Inject
    lateinit var service: SpangService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // do something..
        val list = arrayListOf<HabitData>(
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기"),
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기"),
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기"),
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기"),
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기"),
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기"),
            HabitData("습관 제목1", "아침 10분 독서","습관 제목2",
                "1시간 운동하기", "습관 제목 3", "아침먹기")

        )

        val adapter = HomeAdapter(this)
        binding.rvHomeHabit.adapter = adapter
        adapter.setRepoList(list)
    }
}

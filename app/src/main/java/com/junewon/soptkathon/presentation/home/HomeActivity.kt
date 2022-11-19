package com.junewon.soptkathon.presentation.home

import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ActivityHomeBinding
import com.junewon.soptkathon.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // do something..
        val list = arrayListOf<HabitData>(
            HabitData("습관11", "습관22","습관33"),
            HabitData("습관11", "습관22","습관33"),
            HabitData("습관11", "습관22","습관33"),
            HabitData("습관11", "습관22","습관33"),
            HabitData("습관11", "습관22","습관33"),
            HabitData("습관11", "습관22","습관33"),
            HabitData("습관11", "습관22","습관33")
        )

        val adapter = HomeAdapter(this)
        binding.rvHomeHabit.adapter = adapter
        adapter.setRepoList(list)
    }
}

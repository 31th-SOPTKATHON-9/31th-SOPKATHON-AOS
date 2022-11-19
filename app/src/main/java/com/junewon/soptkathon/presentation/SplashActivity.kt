package com.junewon.soptkathon.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.ActivitySplashBinding
import com.junewon.soptkathon.presentation.home.HomeActivity
import com.junewon.soptkathon.util.binding.BindingActivity
import com.junewon.soptkathon.util.extension.startActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lottieSplashImg.playAnimation()
        lifecycleScope.launch {
            delay(2000)
            startActivity<HomeActivity>()
            overridePendingTransition(0, 0)
            finish()
        }
    }
}

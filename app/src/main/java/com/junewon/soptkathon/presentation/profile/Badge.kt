package com.junewon.soptkathon.presentation.profile

import androidx.annotation.DrawableRes

data class Badge(
    @DrawableRes val image:Int,
    val name:String,
    val isLocked : Boolean
)

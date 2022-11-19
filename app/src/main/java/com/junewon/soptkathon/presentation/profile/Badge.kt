package com.junewon.soptkathon.presentation.profile

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Badge(
    @DrawableRes val image: Int,
    val name: String,
    val level: String,
    val isLocked: Boolean,
    val description: String = "우리 흥민이 절대 월드클래스 아닙니다."
) : Parcelable

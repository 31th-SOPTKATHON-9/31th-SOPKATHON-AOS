package com.junewon.soptkathon.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.RoundedCornersTransformation
import com.junewon.soptkathon.R

@BindingAdapter("app:circelImageUrl")
fun ImageView.loadCircleImage(imageUrl: String?) {
    load(imageUrl) {
        placeholder(R.drawable.ic_launcher_background)
            .transformations(RoundedCornersTransformation(50f))
            .crossfade(true)
            .error(R.drawable.ic_launcher_background)
    }
}

@BindingAdapter("app:imageUrl")
fun ImageView.loadImage(imageUrl: String?) {
    load(imageUrl) {
        placeholder(R.drawable.ic_launcher_background)
            .crossfade(true)
            .error(R.drawable.ic_launcher_background)
    }
}

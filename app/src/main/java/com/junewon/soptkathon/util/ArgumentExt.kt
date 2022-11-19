package com.junewon.soptkathon.util

import android.os.Bundle
import androidx.fragment.app.Fragment

inline fun <T : Fragment> T.withArgs(argsBuilder: Bundle.() -> Unit): T {
    return this.apply {
        arguments = Bundle().apply(argsBuilder)
    }
}

package com.junewon.soptkathon.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.junewon.soptkathon.R
import com.junewon.soptkathon.databinding.DialogBadgeBinding

class BadgeBottomSheetDialog : BottomSheetDialogFragment() {
    private var _binding: DialogBadgeBinding? = null
    private val binding get() = _binding ?: error("바인딩에 null")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DialogBadgeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBadge.load(R.drawable.ic_launcher_background) {
            placeholder(R.drawable.ic_launcher_background)
                .transformations(RoundedCornersTransformation(28f))
                .crossfade(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

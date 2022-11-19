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
import com.junewon.soptkathon.presentation.profile.ProfileActivity.Companion.BADGE

class BadgeBottomSheetDialog : BottomSheetDialogFragment() {
    private var _binding: DialogBadgeBinding? = null
    private val binding get() = _binding ?: error("바인딩에 null")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        initDialog()
    }
    private fun initDialog() {
        val data = requireArguments().getParcelable<Badge>(BADGE)!!
        binding.ivBadge.load(data.image) {
            placeholder(R.drawable.ic_launcher_background)
                .transformations(RoundedCornersTransformation(28f))
                .crossfade(true)
        }
        binding.tvBadgeName.text = data.name
        binding.tvLevel.text = data.level
        binding.tvDescription.text = data.description
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

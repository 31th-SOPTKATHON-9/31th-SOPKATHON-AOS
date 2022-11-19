package com.junewon.soptkathon.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ProgressDataResponse(
    val count: Int,
    val progress: Int
)

package com.junewon.soptkathon.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val data: T,
    val message: String,
    val status: Int,
    val success: Boolean
)

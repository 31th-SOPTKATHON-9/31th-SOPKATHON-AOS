package com.junewon.soptkathon.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseUserDTO(
    val userId: String,
    val starId: String
)

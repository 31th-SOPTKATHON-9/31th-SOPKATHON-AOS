package com.junewon.soptkathon.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val statId: String
)

package com.junewon.soptkathon.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseSearchDTO(
    @SerialName("star")
    val stars: List<Star> = emptyList()
)

@Serializable
data class Star(
    val habits: List<Habit> = emptyList(),
    val starId: String = "",
    val title: String = "",
    val introduce: String = "",
    val starName: String = ""
)

@Serializable
data class Habit(
    val desc: String = "",
    val id: Int = -1,
    val title: String = "",
    val isCheck: Boolean = false,
)


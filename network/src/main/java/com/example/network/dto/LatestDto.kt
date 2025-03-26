package com.example.network.dto

import kotlinx.serialization.SerialName

data class LatestDto(
    @SerialName("base")
    val base: String,
    @SerialName("date")
    val date: String,
    @SerialName("rates")
    val rates: Map<String,Double>,
    @SerialName("success")
    val success: Boolean
)


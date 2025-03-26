package com.example.network.dto

import kotlinx.serialization.SerialName

data class SymbolsDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("symbols")
    val symbols: Map<String, String>
)
package com.example.core.entity

data class BaseCurrencyState(
    val baseCurrency: Symbols = Symbols("", ""),
    val list: List<Symbols> = listOf()
)

data class Symbols(
    val code: String,
    val name: String
)
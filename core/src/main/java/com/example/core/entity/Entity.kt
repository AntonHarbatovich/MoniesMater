package com.example.core.entity

data class BaseCurrencyState(
    val baseCurrency: Symbols = Symbols("", ""),
    val list: List<Symbols> = listOf()
)

data class Symbols(
    val code: String,
    val name: String
)

data class Account(
    val id: Int,
    val name: String = "Cash",
    val description: String = "Cash for presents",
    val type: AccountType = AccountType.CASH,
    val currency: String = "USD",
    val balance: Double = 1000.00
)

enum class AccountType {
    CASH,
    CARD,
    BANK
}
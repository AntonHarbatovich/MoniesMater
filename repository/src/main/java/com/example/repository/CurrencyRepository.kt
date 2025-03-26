package com.example.repository

import com.example.core.entity.Symbols
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {
    suspend fun getSymbols(): Flow<Result<List<Symbols>>>
}
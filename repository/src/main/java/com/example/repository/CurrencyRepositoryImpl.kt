package com.example.repository

import com.example.core.entity.Symbols
import com.example.core.runSuspendCatching
import com.example.network.CurrencyService
import com.example.repository.mappers.SymbolsMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val service: CurrencyService,
    private val symbolsMapper: SymbolsMapper
) : CurrencyRepository {
    override suspend fun getSymbols(): Flow<Result<List<Symbols>>> = flow {
        emit(runSuspendCatching {
            symbolsMapper.map(service.getSymbols())
        })
    }

    override suspend fun saveBaseCurrency(baseCurrency: Symbols) {

    }

}
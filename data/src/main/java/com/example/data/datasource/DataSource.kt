package com.example.data.datasource

import com.example.data.database.entity.SymbolsDb

interface DataSource {
    suspend fun saveBaseCurrency(symbolsDb: SymbolsDb)
}
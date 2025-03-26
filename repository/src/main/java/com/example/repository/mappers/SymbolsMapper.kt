package com.example.repository.mappers

import com.example.core.entity.Symbols
import com.example.network.dto.SymbolsDto
import javax.inject.Inject

class SymbolsMapper @Inject constructor() {
    fun map(symbolsDto: SymbolsDto): List<Symbols> {
        return symbolsDto.symbols.map { entry ->
            Symbols(
                code = entry.key,
                name = entry.value
            )
        }
    }
}
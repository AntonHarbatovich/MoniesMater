package com.example.network

import com.example.network.dto.LatestDto
import com.example.network.dto.SymbolsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {
    @GET("/api/latest")
    suspend fun getLatestCurrencies(
        @Query("base") base: String
    ): Response<LatestDto>


    @GET("/api/symbols")
    suspend fun getSymbols():SymbolsDto
}
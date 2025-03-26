package com.example.repository

import com.example.network.CurrencyService
import com.example.repository.mappers.SymbolsMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CurrencyRepositoryModule {

    @Provides
    fun providesCurrencyRepository(
        service: CurrencyService,
        symbolsMapper: SymbolsMapper
    ): CurrencyRepository {
        return CurrencyRepositoryImpl(service, symbolsMapper)
    }

}

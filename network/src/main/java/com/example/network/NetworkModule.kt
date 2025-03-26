package com.example.network

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Cache
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun provideExchangeRatesService(okHttpClient: OkHttpClient): CurrencyService {
        val contentType = "application/json".toMediaTypeOrNull()
            ?: throw IllegalArgumentException("Should be not null")
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(okHttpClient)
            .build()
            .create(CurrencyService::class.java)
    }

    @Provides
    @Singleton
    fun provideOtherInterceptorOkHttpClient(
        @ApplicationContext
        context: Context,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(AuthorizationInterceptor())
            .cache(createCache(context))
            .build()
    }

    private fun createCache(context: Context): Cache {
        return Cache(
            directory = context.cacheDir.resolve(HTTP_CACHE_DIR),
            maxSize = CACHE_SIZE,
        )
    }

    private const val HTTP_CACHE_DIR = "http_cache"
    private const val CACHE_SIZE = 20L * 1024L * 1024L // 20 MB
    private const val BASE_URL = "http://data.fixer.io"
}
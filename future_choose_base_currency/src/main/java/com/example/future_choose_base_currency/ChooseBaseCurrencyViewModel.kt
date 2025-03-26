package com.example.future_choose_base_currency

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.entity.BaseCurrencyState
import com.example.core.entity.Symbols
import com.example.core.resolve
import com.example.repository.CurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ChooseBaseCurrencyViewModel @Inject constructor(
    private val repository: CurrencyRepository
) : ViewModel() {
    private val _baseCurrencyState = mutableStateOf(BaseCurrencyState())
    val baseCurrencyState: State<BaseCurrencyState> get() = _baseCurrencyState

    init {
        getLatestCurrencies()
    }

    private fun getLatestCurrencies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getSymbols().collect { result ->
                    result.resolve(
                        onSuccess = { list ->
                            _baseCurrencyState.value = baseCurrencyState.value.copy(list = list)
                        },
                        onError = { throwable -> Log.e("viewmodel", "${throwable.message}") }
                    )
                }
            }
        }
    }

    fun setBaseCurrency(symbols: Symbols) {
        _baseCurrencyState.value = baseCurrencyState.value.copy(baseCurrency = symbols)
    }

    fun saveBaseCurrency() {
        viewModelScope.launch {
            repository.saveBaseCurrency(baseCurrencyState.value.baseCurrency)
        }
    }
}
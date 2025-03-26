package com.example.future_choose_base_currency

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.entity.Symbols
import com.example.core.navigation.Currencies
import com.example.ui_kit.screns.BigTitle
import com.example.ui_kit.screns.ButtonCenter
import com.example.ui_kit.screns.ButtonWithTextLayout
import com.example.ui_kit.screns.RoundedWhiteColumn
import com.example.ui_kit.theme.AppTheme

@Composable
fun ChooseBaseCurrencyScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ChooseBaseCurrencyViewModel = hiltViewModel(),
) {
    val state by viewModel.baseCurrencyState

    Column(
        modifier = modifier
            .background(AppTheme.colors.colorMainGreen)
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        ChooseBaseCurrencyContent(
            navHostController = navHostController,
            symbols = state.baseCurrency
        )
    }
}

@Composable
fun ChooseBaseCurrencyContent(
    navHostController: NavHostController,
    symbols: Symbols,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        val currencyText: String =
            if (symbols.code.isNotEmpty() && symbols.name.isNotEmpty())
                symbols.code + " - " + symbols.name
            else ""
        BigTitle(
            title = stringResource(R.string.title_welcome),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = AppTheme.sizes.large, horizontal = AppTheme.sizes.medium)
        )
        RoundedWhiteColumn(modifier = Modifier.fillMaxSize()) {
            Text(
                stringResource(R.string.title_base_currency),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = AppTheme.sizes.larger,
                        start = AppTheme.sizes.medium,
                        end = AppTheme.sizes.medium
                    ),
                style = AppTheme.typography.semiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
            ButtonWithTextLayout(
                stringResource(R.string.choose_base_currency),
                currencyText,
                { navHostController.navigate(Currencies) },
                modifier = Modifier.padding(
                    top = AppTheme.sizes.larger,
                    start = AppTheme.sizes.medium,
                    end = AppTheme.sizes.medium
                )
            )
            ButtonCenter(
                stringResource(R.string.cont),
                symbols.code.isNotEmpty()
                        || symbols.name.isNotEmpty(),
                { navHostController.navigate(Currencies) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = AppTheme.sizes.larger)
            )
        }
    }
}

@Preview
@Composable
fun ChooseBaseCurrencyScreenPreview() {
    Surface(
        modifier = Modifier.background(AppTheme.colors.colorMainGreen)
    ) {
        ChooseBaseCurrencyContent(
            rememberNavController(),
            symbols = Symbols(
                code = "Usd",
                name = "Adsdasdasd"
            )
        )
    }


}
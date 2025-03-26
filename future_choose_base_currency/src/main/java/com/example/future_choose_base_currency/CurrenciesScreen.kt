package com.example.future_choose_base_currency

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.core.entity.Symbols
import com.example.ui_kit.screns.AppBar
import com.example.ui_kit.screns.RoundedWhiteColumn
import com.example.ui_kit.theme.AppTheme

@Composable
fun CurrenciesScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: ChooseBaseCurrencyViewModel = hiltViewModel(),
) {
    val state by viewModel.baseCurrencyState

    Scaffold(
        modifier = modifier.statusBarsPadding(),
        topBar = {
            AppBar(
                appBarTitle = stringResource(R.string.title_currencies),
                onBackClick = { navHostController.popBackStack() },
                modifier = Modifier.background(AppTheme.colors.colorMainGreen)
            )
        }) {
        CurrenciesContent(
            onItemClick = { symbols ->
                viewModel.setBaseCurrency(symbols)
                navHostController.popBackStack()
            },
            items = state.list,
            padding = it
        )
    }

}

@Composable
fun CurrenciesContent(
    onItemClick: (Symbols) -> Unit,
    items: List<Symbols>,
    padding: PaddingValues,
    modifier: Modifier = Modifier,

    ) {
    Column(
        modifier = modifier
            .padding(padding)
            .background(AppTheme.colors.colorMainGreen)
            .fillMaxSize()
    ) {

        RoundedWhiteColumn(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = AppTheme.sizes.large)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = AppTheme.sizes.large)
            ) {
                items(items) {
                    CurrencyItem(it, { onItemClick.invoke(it) })
                }
            }
        }
    }

}

@Composable
fun CurrencyItem(
    symbol: Symbols,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = AppTheme.sizes.large)
            .clickable { onItemClick.invoke() }
    ) {
        Row(
            modifier = Modifier.padding(top = AppTheme.sizes.medium)
        ) {
            Text(
                text = symbol.code,
                modifier = Modifier.width(50.dp),
                style = AppTheme.typography.medium,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                color = AppTheme.colors.colorLettersAndIcons
            )

            Text(
                text = symbol.name,
                modifier = Modifier,
                style = AppTheme.typography.medium,
                fontSize = 15.sp,
                textAlign = TextAlign.Start,
                color = AppTheme.colors.colorLettersAndIcons
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(top = AppTheme.sizes.small),
            thickness = 1.dp,
            color = AppTheme.colors.colorMainGreen
        )
    }
}


@Preview
@Composable
fun CurrenciesContentPreview(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.background(AppTheme.colors.colorMainGreen)
    ) {
        CurrenciesContent(
            {},
            items = listOf(
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AFN", name = "Afghan Afghani"),
                Symbols(code = "ALL", name = "Albanian Lek"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AFN", name = "Afghan Afghani"),
                Symbols(code = "ALL", name = "Albanian Lek"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AFN", name = "Afghan Afghani"),
                Symbols(code = "ALL", name = "Albanian Lek"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AFN", name = "Afghan Afghani"),
                Symbols(code = "ALL", name = "Albanian Lek"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
                Symbols(code = "AED", name = "United Arab Emirates Dirham"),
            ),
            padding = PaddingValues()
        )
    }
}
package com.example.monies_mater

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.ChooseBaseCurrency
import com.example.core.navigation.Currencies
import com.example.core.navigation.Home
import com.example.core.navigation.Splash
import com.example.future_choose_base_currency.ChooseBaseCurrencyScreen
import com.example.future_choose_base_currency.ChooseBaseCurrencyViewModel
import com.example.future_choose_base_currency.CurrenciesScreen
import com.example.future_home.HomeScreen
import com.example.ui_kit.theme.AppTheme
import com.example.ui_kit.theme.MoniesMaterTheme

@Composable
fun MoniesMaterApp(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false
) {
    MoniesMaterTheme(darkTheme = darkTheme) {
        Surface(
            color = AppTheme.colors.colorMainGreen,
            modifier = modifier
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Splash,
            ) {
                composable<Splash> {
                    SplashScreen(navHostController = navController)
                }
                composable<ChooseBaseCurrency> {
                    ChooseBaseCurrencyScreen(
                        navHostController = navController
                    )
                }
                composable<Currencies> {
                    val parentEntry = remember(it) {
                        navController.getBackStackEntry(ChooseBaseCurrency)
                    }
                    val viewModel = hiltViewModel<ChooseBaseCurrencyViewModel>(parentEntry)
                    CurrenciesScreen(
                        navHostController = navController,
                        viewModel = viewModel
                    )
                }
                composable<Home> {
                    HomeScreen(
                        navHostController = navController,

                        )
                }
            }
        }
    }
}
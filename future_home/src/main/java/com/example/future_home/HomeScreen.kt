package com.example.future_home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.entity.Account
import com.example.core.navigation.Home
import com.example.ui_kit.R
import com.example.ui_kit.screns.AccountCard
import com.example.ui_kit.screns.HomeAppBar
import com.example.ui_kit.screns.RoundedWhiteColumn
import com.example.ui_kit.theme.AppTheme

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = modifier
            .statusBarsPadding(),
        topBar = {
            HomeAppBar(
                "Hi, Welcome Back",
                { navHostController.navigate(Home) },
                modifier = Modifier.background(AppTheme.colors.colorMainGreen)
            )
        }
    ) { padding ->
        HomeContent(padding)
    }

}

@Composable
fun HomeContent(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(AppTheme.colors.colorMainGreen)
            .padding(paddingValues)
    ) {
        TotalContent(
            modifier = Modifier
        )
        RoundedWhiteColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = AppTheme.sizes.medium)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = AppTheme.sizes.large)
            ) {
                val items = mutableListOf<Account>(Account(1), Account(2), Account(3))
                items(items) {
                    AccountCard(account = it)
                }
            }
        }
    }
}

@Composable
fun TotalContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(top = AppTheme.sizes.medium)
            .padding(horizontal = AppTheme.sizes.large)
    ) {
        TotalDescription(
            image = ImageVector.vectorResource(R.drawable.currency),
            text = stringResource(R.string.currency)
        )
        CurrencyValue(
            "USD",
            AppTheme.colors.colorBlueButton,
            {
                // need add open Currencies screen
            }
        )
        TotalDescription(
            image = ImageVector.vectorResource(R.drawable.income),
            text = stringResource(R.string.total_balance),
            modifier = Modifier.padding(top = AppTheme.sizes.small)
        )
        TotalValue(
            "100000000",
            AppTheme.colors.colorBackgroundGreenWhiteAndLetters
        )

        TotalDescription(
            image = ImageVector.vectorResource(R.drawable.expense),
            text = stringResource(R.string.total_expense),
            modifier = Modifier.padding(top = AppTheme.sizes.small)
        )

        TotalValue(
            "0.00",
            AppTheme.colors.colorOceanBlueButton
        )

    }
}

@Composable
fun TotalValue(
    value: String,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            value,
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.TopStart),
            textAlign = TextAlign.Start,
            style = AppTheme.typography.bold,
            fontSize = 24.sp,
            color = textColor,
        )
    }
}

@Composable
fun CurrencyValue(
    value: String,
    textColor: Color,
    onValueClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Text(
            value,
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.TopStart)
                .drawBehind {
                    val strokeWidthPx = 1.dp.toPx()
                    val verticalOffset = size.height - 2.sp.toPx()
                    drawLine(
                        color = textColor,
                        strokeWidth = strokeWidthPx,
                        start = Offset(0f, verticalOffset),
                        end = Offset(size.width, verticalOffset)
                    )
                }
                .clickable { onValueClick.invoke() },
            textAlign = TextAlign.Start,
            style = AppTheme.typography.bold,
            fontSize = 24.sp,
            color = textColor,
        )
    }
}

@Composable
fun TotalDescription(
    image: ImageVector,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            imageVector = image,
            modifier = Modifier.padding(end = AppTheme.sizes.smaller),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(AppTheme.colors.colorLettersAndIcons)
        )
        Text(
            text,
            modifier = Modifier.wrapContentWidth(),
            textAlign = TextAlign.Start,
            style = AppTheme.typography.regular,
            fontSize = 14.sp,
            color = AppTheme.colors.colorLettersAndIcons
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
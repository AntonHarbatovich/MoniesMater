package com.example.ui_kit.screns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core.entity.Account
import com.example.core.entity.AccountType
import com.example.ui_kit.R
import com.example.ui_kit.theme.AppTheme

@Composable
fun AccountCard(
    account: Account,
    modifier: Modifier = Modifier
) {
    val drawable = when (account.type) {
        AccountType.CARD -> R.drawable.icon_card
        AccountType.CASH -> R.drawable.icon_cash
        else -> R.drawable.icon_bank
    }
    val image = ImageVector.vectorResource(drawable)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppTheme.sizes.medium, vertical = AppTheme.sizes.smaller)
            .clip(
                RoundedCornerShape(
                    AppTheme.sizes.medium
                )
            )
            .background(AppTheme.colors.colorBlueButton)

    ) {
        Row(
            modifier = Modifier
                .width(IntrinsicSize.Min)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(AppTheme.sizes.small)
                    .clip(RoundedCornerShape(AppTheme.sizes.medium))
                    .background(AppTheme.colors.colorLightBlueButton)
            ) {
                Image(
                    imageVector = image,
                    modifier = Modifier
                        .padding(AppTheme.sizes.medium),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.tint(AppTheme.colors.colorBackgroundGreenWhiteAndLetters)
                )
            }

            Column(
                modifier = Modifier
                    .weight(4f)
                    .padding(horizontal = AppTheme.sizes.small),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    account.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppTheme.sizes.small),
                    textAlign = TextAlign.Start,
                    style = AppTheme.typography.semiBold,
                    fontSize = 16.sp,
                    color = AppTheme.colors.colorLettersAndIcons
                )
                Text(
                    "${account.balance} ${account.currency}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = AppTheme.sizes.small),
                    textAlign = TextAlign.Start,
                    style = AppTheme.typography.semiBold,
                    fontSize = 16.sp,
                    color = AppTheme.colors.colorBackgroundGreenWhiteAndLetters
                )
            }

        }

        Text(
            account.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppTheme.sizes.small)
                .padding(horizontal = AppTheme.sizes.medium),
            textAlign = TextAlign.Start,
            style = AppTheme.typography.regular,
            fontSize = 12.sp,
            color = AppTheme.colors.colorLettersAndIcons
        )
    }
}

@Preview
@Composable
fun AccountCardPreview() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { }
    AccountCard(
        Account(id = 1)
    )
}
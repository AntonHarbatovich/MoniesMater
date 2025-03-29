package com.example.future_add_account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_kit.R
import com.example.ui_kit.screns.AccountRadioGroup
import com.example.ui_kit.screns.AppBar
import com.example.ui_kit.screns.CustomTextField
import com.example.ui_kit.screns.RoundedWhiteColumn
import com.example.ui_kit.theme.AppTheme

@Composable
fun AddAccountScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
            .statusBarsPadding(),
        topBar = {
            AppBar(
                appBarTitle = stringResource(R.string.title_add_account),
                {
//                    need add return previos screen
                },
                modifier = Modifier.background(AppTheme.colors.colorMainGreen)
            )
        }
    ) { padding ->
        AddAccountContent(padding)
    }

}

@Composable
fun AddAccountContent(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(paddingValues)
            .background(AppTheme.colors.colorMainGreen)
            .fillMaxSize()
    ) {

        RoundedWhiteColumn(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = AppTheme.sizes.large)
        ) {
            val accountName = ""
            AccountTextWithTextField(
                text = stringResource(R.string.account_name),
                hint = stringResource(R.string.hint_account_name),
                textTextField = accountName,
                onValueChange = {},
                modifier = Modifier
                    .padding(
                        start = AppTheme.sizes.medium,
                        end = AppTheme.sizes.medium,
                        top = AppTheme.sizes.large
                    )
            )
            val accountDescription = ""
            AccountTextWithTextField(
                text = stringResource(R.string.account_description),
                hint = stringResource(R.string.hint_account_description),
                textTextField = accountDescription,
                onValueChange = {},
                modifier = Modifier
                    .padding(horizontal = AppTheme.sizes.medium)
                    .padding(top = AppTheme.sizes.medium)
            )

            Text(
                text = stringResource(R.string.account_type),
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = AppTheme.sizes.large, top = AppTheme.sizes.medium),
                textAlign = TextAlign.Start,
                style = AppTheme.typography.regular,
                fontSize = 15.sp,
                color = AppTheme.colors.colorDarkModeGreenBlack
            )

            AccountRadioGroup(
                modifier = Modifier
                    .padding(top = AppTheme.sizes.smaller)
                    .padding(horizontal = AppTheme.sizes.medium)
            ) {}

            Text(
                stringResource(R.string.account_currency),
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = AppTheme.sizes.large, top = AppTheme.sizes.small),
                textAlign = TextAlign.Start,
                style = AppTheme.typography.regular,
                fontSize = 15.sp,
                color = AppTheme.colors.colorDarkModeGreenBlack
            )
            TextButton(
                onClick = { },
                modifier = Modifier
                    .wrapContentWidth()
                    .height(48.dp)
                    .padding(horizontal = AppTheme.sizes.medium)
                    .padding(top = AppTheme.sizes.smaller)
                    .align(Alignment.Start),
                colors = ButtonColors(
                    contentColor = AppTheme.colors.colorDarkModeGreenBlack,
                    containerColor = AppTheme.colors.colorLightGreen,
                    disabledContentColor = AppTheme.colors.colorDarkModeGreenBlack,
                    disabledContainerColor = AppTheme.colors.colorLightGreen,
                )
            ) {
                Text(
                    text = ""
//                    textButton ?: ""
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AppTheme.sizes.small),
                    style = AppTheme.typography.regular,
                    fontSize = 16.sp,
                    color = AppTheme.colors.colorLettersAndIcons,
                    textAlign = TextAlign.Start
                )
            }
            val accountBalance = 0
            AccountTextWithTextField(
                text = stringResource(R.string.account_balance),
                hint = "",
                textTextField = accountBalance.toString(),
                onValueChange = {},
                modifier = Modifier
                    .padding(horizontal = AppTheme.sizes.medium)
                    .padding(top = AppTheme.sizes.medium)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = AppTheme.sizes.large),
            ) {

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(
                            horizontal = AppTheme.sizes.medium,
                            vertical = AppTheme.sizes.large
                        ),
                    colors = ButtonColors(
                        contentColor = AppTheme.colors.colorLettersAndIcons,
                        containerColor = AppTheme.colors.colorMainGreen,
                        disabledContentColor = AppTheme.colors.colorDisableLettersAndIcons,
                        disabledContainerColor = AppTheme.colors.colorDisableMainGreen
                    ),
                    enabled = true
                ) {
                    Text(
                        stringResource(R.string.save),
                        style = AppTheme.typography.semiBold,
                        fontSize = 20.sp
                    )
                }
            }

        }
    }
}


@Composable
fun AccountTextWithTextField(
    text: String,
    hint: String,
    textTextField: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = text,
            modifier = Modifier
                .wrapContentWidth()
                .padding(start = AppTheme.sizes.medium),
            textAlign = TextAlign.Start,
            style = AppTheme.typography.regular,
            fontSize = 15.sp,
            color = AppTheme.colors.colorDarkModeGreenBlack
        )
        CustomTextField(
            hint = hint,
            text = textTextField,
            onValueChange = onValueChange,
            modifier = Modifier.padding(top = AppTheme.sizes.smaller)
        )
    }

}

@Preview
@Composable
fun AddAccountContentPreview() {
    AddAccountScreen()
}
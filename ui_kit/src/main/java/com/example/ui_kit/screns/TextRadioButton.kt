package com.example.ui_kit.screns

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core.entity.AccountType
import com.example.ui_kit.theme.AppTheme

@Composable
fun TextRadioButton(
    optionSelected: String,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}

) {
    Row(
        modifier = modifier
            .padding(horizontal = AppTheme.sizes.small)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            optionSelected == text,
            onClick = onClick,
            modifier = Modifier,
            colors = RadioButtonColors(
                selectedColor = AppTheme.colors.colorMainGreen,
                unselectedColor = AppTheme.colors.colorMainGreen,
                disabledSelectedColor = AppTheme.colors.colorDisableMainGreen,
                disabledUnselectedColor = AppTheme.colors.colorDisableMainGreen
            )
        )

        Text(
            text = text,
            modifier = Modifier
                .wrapContentWidth(),
            textAlign = TextAlign.Start,
            style = AppTheme.typography.regular,
            fontSize = 16.sp,
            color = AppTheme.colors.colorDarkModeGreenBlack
        )

    }
}


@Preview
@Composable
fun TextRadioButtonPreview() {
    val selected = AccountType.CASH.name
    val defaultText = AccountType.BANK.name
    TextRadioButton(
        selected,
        defaultText,
        modifier = Modifier.background(Color.White)
    )
}

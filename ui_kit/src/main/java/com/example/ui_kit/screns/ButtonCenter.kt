package com.example.ui_kit.screns

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_kit.theme.AppTheme

@Composable
fun ButtonCenter(
    text: String,
    enabled: Boolean,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .wrapContentWidth()
                .defaultMinSize(minWidth = 200.dp),
            colors = ButtonColors(
                contentColor = AppTheme.colors.colorLettersAndIcons,
                containerColor = AppTheme.colors.colorMainGreen,
                disabledContentColor = AppTheme.colors.colorDisableLettersAndIcons,
                disabledContainerColor = AppTheme.colors.colorDisableMainGreen
            ),
            enabled = enabled
        ) {
            Text(
                text,
                style = AppTheme.typography.semiBold,
                fontSize = 20.sp
            )
        }
    }
}

@Preview
@Composable
fun ButtonCenterPreview() {
    ButtonCenter(
        "Hello",
        true,
        {}
    )
}
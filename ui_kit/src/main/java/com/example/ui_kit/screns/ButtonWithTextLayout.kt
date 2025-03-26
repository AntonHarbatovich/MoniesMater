package com.example.ui_kit.screns

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ui_kit.theme.AppTheme

@Composable
fun ButtonWithTextLayout(
    descriptionLayout: String,
    textButton: String?,
    onTextButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            descriptionLayout,
            modifier = Modifier
                .padding(horizontal = AppTheme.sizes.small, vertical = AppTheme.sizes.smaller)
                .align(Alignment.Start),
            style = AppTheme.typography.medium,
            fontSize = 15.sp,
            color = AppTheme.colors.colorLettersAndIcons
        )
        TextButton(
            onClick = { onTextButtonClick.invoke() },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            colors = ButtonColors(
                contentColor = AppTheme.colors.colorLettersAndIcons,
                containerColor = AppTheme.colors.colorLightGreen,
                disabledContentColor = AppTheme.colors.colorLettersAndIcons,
                disabledContainerColor = AppTheme.colors.colorLightGreen,
            )
        ) {
            Text(
                text = textButton ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = AppTheme.sizes.small),
                style = AppTheme.typography.regular,
                fontSize = 16.sp,
                color = AppTheme.colors.colorLettersAndIcons,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview
@Composable
fun ButtonWithTextLayoutPreview() {
    Surface(
        modifier = Modifier.background(Color.White)
    ) {
        ButtonWithTextLayout(
            "Choose",
            "answer", {}
        )
    }
}
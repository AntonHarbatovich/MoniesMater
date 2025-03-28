package com.example.ui_kit.screns

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ui_kit.theme.AppTheme

@Composable
fun BigTitle(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        title,
        modifier = modifier
            .wrapContentHeight(),
        textAlign = TextAlign.Center,
        style = AppTheme.typography.semiBold,
        fontSize = 30.sp,
        color = AppTheme.colors.colorLettersAndIcons
    )
}

@Preview
@Composable
fun BigTitlePreview() {
    Surface(modifier = Modifier.background(Color.White)) { BigTitle("Welcome") }
}
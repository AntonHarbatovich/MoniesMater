package com.example.ui_kit.screns

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.ui_kit.theme.AppTheme

@Composable
fun RoundedWhiteColumn(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = AppTheme.sizes.larger,
                    topEnd = AppTheme.sizes.larger
                )
            )
            .background(AppTheme.colors.colorBackgroundGreenWhiteAndLetters),
        content = content
    )
}
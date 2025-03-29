package com.example.ui_kit.screns

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_kit.theme.AppTheme

@Composable
fun CustomTextField(
    hint: String,
    modifier: Modifier = Modifier,
    text: String = "",
    onValueChange: (String) -> Unit
) {
    var hasFocus by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = if (hasFocus || text.isNotEmpty()) text else hint,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .onFocusChanged { hasFocus = it.hasFocus },
        shape = RoundedCornerShape(AppTheme.sizes.large),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = AppTheme.colors.colorLightGreen,
            focusedContainerColor = AppTheme.colors.colorLightGreen,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = AppTheme.colors.colorDarkModeGreenBar,
            unfocusedTextColor = AppTheme.colors.colorDisableDarkModeGreenBar
        ),
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    var string by remember { mutableStateOf("") }
    CustomTextField(
        hint = "Enter text",
        text = ""
    ) { string = it }
}
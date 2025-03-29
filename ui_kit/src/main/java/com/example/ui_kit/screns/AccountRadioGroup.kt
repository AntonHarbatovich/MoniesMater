package com.example.ui_kit.screns

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.core.entity.AccountType

@Composable
fun AccountRadioGroup(
    modifier: Modifier = Modifier,
    onclick: (AccountType) -> Unit = {},
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        var typeSelected by remember { mutableStateOf(AccountType.CASH) }
        AccountType.entries.forEach { type ->
            TextRadioButton(
                optionSelected = typeSelected.name,
                text = type.name,
                onClick = {
                    typeSelected = type
                    onclick.invoke(type)
                },
                modifier = Modifier.weight(1f)
            )
        }
    }

}
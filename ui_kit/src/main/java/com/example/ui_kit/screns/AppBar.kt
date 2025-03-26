package com.example.ui_kit.screns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_kit.theme.AppTheme

@Composable
fun AppBar(
    appBarTitle: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(AppTheme.sizes.appBarHeight)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clickable { onBackClick.invoke() },
            contentAlignment = Alignment.Center
        ) {
            val image: ImageVector =
                ImageVector.vectorResource(com.example.ui_kit.R.drawable.arrow_back)
            Image(
                imageVector = image,
                modifier = Modifier
                    .padding(start = AppTheme.sizes.medium),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }

        Text(
            text = appBarTitle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp),
            textAlign = TextAlign.Center,
            style = AppTheme.typography.title,
            color = AppTheme.colors.colorLettersAndIcons
        )
    }

}

@Preview
@Composable
fun AppBarPreview() {
    AppBar(
        appBarTitle = "Title",
        onBackClick = {},
        modifier = Modifier.background(AppTheme.colors.colorMainGreen)
    )
}
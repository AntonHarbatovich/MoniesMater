package com.example.ui_kit.screns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_kit.R
import com.example.ui_kit.theme.AppTheme
import java.util.Calendar

@Composable
fun HomeAppBar(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cal = Calendar.getInstance()
    val hours = cal.get(Calendar.HOUR_OF_DAY)
    Box(
        modifier = modifier
            .height(AppTheme.sizes.appBarHeight)
            .fillMaxWidth()
            .padding(start = AppTheme.sizes.medium, end = AppTheme.sizes.small)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = AppTheme.sizes.smaller),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = title,
                modifier = Modifier
                    .wrapContentSize(),
                textAlign = TextAlign.Start,
                style = AppTheme.typography.semiBold,
                fontSize = 20.sp,
                color = AppTheme.colors.colorBackgroundDarkModeAndLetters
            )
            val greeting = when (hours) {
                in 0..5 -> stringResource(R.string.greeting_night)
                in 6..11 -> stringResource(R.string.greeting_morning)
                in 12..17 -> stringResource(R.string.greeting_afternoon)
                else -> stringResource(R.string.greeting_evening)
            }
            Text(
                greeting,
                modifier = Modifier
                    .wrapContentSize(),
                textAlign = TextAlign.Start,
                style = AppTheme.typography.regular,
                fontSize = 14.sp,
                color = AppTheme.colors.colorBackgroundDarkModeAndLetters
            )
        }
        BoxAdd(
            onClick = onClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
        )

    }

}

@Composable
fun BoxAdd(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(AppTheme.sizes.small)
            .size(40.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(AppTheme.colors.colorLightGreen)
            .clickable { onClick.invoke() }
    ) {
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.add),
            modifier = Modifier
                .padding(AppTheme.sizes.small),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            colorFilter = ColorFilter.tint(AppTheme.colors.colorLettersAndIcons)
        )
    }
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar(
        title = "Hi, Welcome Back",
        {},
        modifier = Modifier.background(AppTheme.colors.colorMainGreen)
    )
}
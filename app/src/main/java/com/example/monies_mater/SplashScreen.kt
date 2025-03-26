package com.example.monies_mater

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.ChooseBaseCurrency
import com.example.core.navigation.Splash
import com.example.moniesmater.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navHostController: NavHostController,
) {
    SplashContent()
    LaunchedEffect(true) {
        delay(500)
        navHostController.navigate(ChooseBaseCurrency) {
            popUpTo(Splash) { inclusive = true }
        }
    }
}

@Composable
fun SplashContent() {
    val image: ImageVector = ImageVector.vectorResource(R.drawable.splash)
    Image(
        imageVector = image,
        modifier = Modifier
            .fillMaxSize(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Preview
@Composable
fun SplashScreenPreview(
) {
    SplashScreen(rememberNavController())
}
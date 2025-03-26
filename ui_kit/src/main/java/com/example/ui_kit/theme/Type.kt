package com.example.ui_kit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ui_kit.R


// Set of Material typography styles to start with
@ConsistentCopyVisibility
data class MoniesMaterTypography internal constructor(
    val bodyLarge: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    val title: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),

    val bold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight.Bold,

        ),

    val semiBold: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
        fontWeight = FontWeight.SemiBold
    ),

    val medium: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.Medium
    ),

    val regular: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)),
        fontWeight = FontWeight.Normal
    ),

    val light: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_light)),
        fontWeight = FontWeight.Light
    ),

    val thin: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_thin)),
        fontWeight = FontWeight.Thin
    ),


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */

    val materialTypography: Typography = Typography(
        bodyMedium = bodyLarge
    ),
)
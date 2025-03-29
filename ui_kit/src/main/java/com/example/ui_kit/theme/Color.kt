package com.example.ui_kit.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

object AppColors {
    val color_letters_and_icons = Color(0xFF093030)
    val color_disable_letters_and_icons = Color(0x80093030)
    val color_dark_mode_green_black = Color(0xFF031314)
    val color_background_dark_mode_and_letters = Color(0xFF052224)
    val color_dark_mode_green_bar = Color(0xFF0E3E3E)
    val color_disable_dark_mode_green_bar = Color(0xB30E3E3E)
    val color_main_green = Color(0xFF00D09E)
    val color_disable_main_green = Color(0x8000D09E)
    val color_light_green = Color(0xFFDFF7E2)
    val color_background_green_white_and_letters = Color(0xFFF1FFF3)
    val color_light_blue_button = Color(0xFF6DB6FE)
    val color_blue_button = Color(0xFF3299FF)
    val color_ocean_blue_button = Color(0xFF0068FF)
}

interface MoniesMaterColors {
    val colorLettersAndIcons: Color
    val colorDarkModeGreenBlack: Color
    val colorBackgroundDarkModeAndLetters: Color
    val colorDarkModeGreenBar: Color
    val colorDisableDarkModeGreenBar: Color
    val colorMainGreen: Color
    val colorLightGreen: Color
    val colorBackgroundGreenWhiteAndLetters: Color
    val colorLightBlueButton: Color
    val colorBlueButton: Color
    val colorOceanBlueButton: Color
    val colorDisableLettersAndIcons:Color
    val colorDisableMainGreen:Color
    val materialColors: ColorScheme
}

fun lightThemeColors(): MoniesMaterColors = object : MoniesMaterColors {
    override val colorLettersAndIcons: Color
        get() = AppColors.color_letters_and_icons
    override val colorDarkModeGreenBlack: Color
        get() = AppColors.color_dark_mode_green_black
    override val colorBackgroundDarkModeAndLetters: Color
        get() = AppColors.color_background_dark_mode_and_letters
    override val colorDarkModeGreenBar: Color
        get() = AppColors.color_dark_mode_green_bar
    override val colorDisableDarkModeGreenBar: Color
        get() = AppColors.color_disable_dark_mode_green_bar
    override val colorMainGreen: Color
        get() = AppColors.color_main_green
    override val colorLightGreen: Color
        get() = AppColors.color_light_green
    override val colorBackgroundGreenWhiteAndLetters: Color
        get() = AppColors.color_background_green_white_and_letters
    override val colorLightBlueButton: Color
        get() = AppColors.color_light_blue_button
    override val colorBlueButton: Color
        get() = AppColors.color_blue_button
    override val colorOceanBlueButton: Color
        get() = AppColors.color_ocean_blue_button
    override val colorDisableLettersAndIcons: Color
        get() = AppColors.color_disable_letters_and_icons
    override val colorDisableMainGreen: Color
        get() = AppColors.color_disable_main_green
    override val materialColors: ColorScheme
        get() = lightColorScheme(
            primary = colorMainGreen,
        )
}

fun darkThemeColors(): MoniesMaterColors = object : MoniesMaterColors {
    override val colorLettersAndIcons: Color
        get() = AppColors.color_letters_and_icons
    override val colorDarkModeGreenBlack: Color
        get() = AppColors.color_dark_mode_green_black
    override val colorBackgroundDarkModeAndLetters: Color
        get() = AppColors.color_background_dark_mode_and_letters
    override val colorDarkModeGreenBar: Color
        get() = AppColors.color_dark_mode_green_bar
    override val colorDisableDarkModeGreenBar: Color
        get() = AppColors.color_disable_dark_mode_green_bar
    override val colorMainGreen: Color
        get() = AppColors.color_main_green
    override val colorLightGreen: Color
        get() = AppColors.color_light_green
    override val colorBackgroundGreenWhiteAndLetters: Color
        get() = AppColors.color_background_green_white_and_letters
    override val colorLightBlueButton: Color
        get() = AppColors.color_light_blue_button
    override val colorBlueButton: Color
        get() = AppColors.color_blue_button
    override val colorOceanBlueButton: Color
        get() = AppColors.color_ocean_blue_button
    override val colorDisableLettersAndIcons: Color
        get() = AppColors.color_disable_letters_and_icons
    override val colorDisableMainGreen: Color
        get() = AppColors.color_disable_main_green
    override val materialColors: ColorScheme
        get() = darkColorScheme(
            primary = colorMainGreen,
        )
}
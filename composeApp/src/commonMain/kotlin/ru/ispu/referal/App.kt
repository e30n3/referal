package ru.ispu.referal

import androidx.compose.runtime.Composable
import ru.ispu.referal.presentation.screen.DefaultScreen
import ru.ispu.referal.presentation.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    DefaultScreen()
}

internal expect fun openUrl(url: String?)
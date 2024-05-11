package ru.ispu.referal

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import com.adeo.kviewmodel.odyssey.setupWithViewModels
import ru.alexgladkov.odyssey.compose.extensions.setupWithActivity
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.alexgladkov.odyssey.core.configuration.DisplayType
import ru.ispu.referal.presentation.navigation.navigationGraph
import ru.ispu.referal.presentation.theme.AppTheme


fun ComponentActivity.setupThemedNavigation() {
    val rootController = RootComposeBuilder().apply { navigationGraph() }.build()
    rootController.setupWithActivity(this)
    rootController.setupWithViewModels()
    setContent {
        AppTheme {
            val configuration = OdysseyConfiguration(
                canvas = this,
                backgroundColor = MaterialTheme.colorScheme.background,
                displayType = DisplayType.FullScreen,
                statusBarColor = MaterialTheme.colorScheme.primary.toArgb(),
                navigationBarColor = MaterialTheme.colorScheme.primary.toArgb()
            )
            Box(Modifier.fillMaxSize()) {
                setNavigationContent(configuration, {
                    finishAndRemoveTask()
                }) {
                    navigationGraph()
                }
            }
        }
    }
}
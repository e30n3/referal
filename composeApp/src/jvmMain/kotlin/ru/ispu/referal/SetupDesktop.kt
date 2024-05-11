package setup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import ru.ispu.referal.presentation.navigation.navigationGraph
import ru.ispu.referal.presentation.theme.AppTheme

fun setupDesktopThemedNavigation() = application {
    Window(
        /* icon = PainterRes.logo(),*/
        onCloseRequest = ::exitApplication,
        title = "Referal",
        state = rememberWindowState(
            width = 480.dp,
            height = 800.dp,
            position = WindowPosition.Aligned(Alignment.Center),
            placement = WindowPlacement.Floating
        )
    ) {
        AppTheme {
            val configuration = OdysseyConfiguration(
                backgroundColor = MaterialTheme.colors.background
            )
            Box(Modifier.fillMaxSize()) {
                setNavigationContent(configuration, onApplicationFinish = {
                    exitApplication()
                }) {
                    navigationGraph()
                }
            }
        }
    }
}
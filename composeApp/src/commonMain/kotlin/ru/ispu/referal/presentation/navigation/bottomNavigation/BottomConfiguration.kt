package ru.ispu.referal.presentation.navigation.bottomNavigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabsNavModel

class BottomConfiguration : TabsNavModel<BottomNavConfiguration>() {

    override val navConfiguration: BottomNavConfiguration
        @Composable
        get() {
            return BottomNavConfiguration(
                backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
                selectedColor = MaterialTheme.colorScheme.onSurface,
                unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                elevation = 0.dp
            )
        }
}
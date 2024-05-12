package ru.ispu.referal.presentation.navigation.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabConfiguration
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.TabItem

class CompanyHomeTab : TabItem() {

    override val configuration: TabConfiguration
        @Composable
        get() {
            return TabConfiguration(
                title = "Главная",
                selectedColor = MaterialTheme.colorScheme.onSurface,
                unselectedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedIcon = rememberVectorPainter(Icons.Filled.Home),
                unselectedIcon = rememberVectorPainter(Icons.Outlined.Home),
                titleStyle = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            )
        }
}
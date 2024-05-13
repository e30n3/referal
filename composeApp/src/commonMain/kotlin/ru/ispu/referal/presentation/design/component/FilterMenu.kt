package ru.ispu.referal.presentation.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterMenu(expanded: Boolean, onDismissRequest: () -> Unit) {
    var expandedSort by remember { mutableStateOf(false) }
    var expandedCategory by remember { mutableStateOf(false) }
    var selectedSortOption by remember { mutableStateOf("цена ↑") }
    var selectedCategoryOption by remember { mutableStateOf("Авто") }

    val sortOptions = listOf("цена ↑", "цена ↓", "комиссия % ↑", "комиссия % ↓")
    val categoryOptions = listOf(
        "Авто",
        "Часы и украшения",
        "Недвижимость",
        "Электроника",
        "Путешествия",
        "Финансы",
        "Искусство",
        "Эксклюзивные услуги"
    )

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = Modifier.width(500.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Sort Drop Down
            Text(
                text = "сортировка",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .clickable { expandedSort = true }
                .padding(8.dp)) {
                Text(text = selectedSortOption)
                DropdownMenu(expanded = expandedSort, onDismissRequest = { expandedSort = false }) {
                    sortOptions.forEach { option ->
                        DropdownMenuItem(text = { Text(text = option) }, onClick = {
                            selectedSortOption = option
                            expandedSort = false
                        })
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Category Drop Down
            Text(
                text = "категория",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .clickable { expandedCategory = true }
                .padding(8.dp)) {
                Text(text = selectedCategoryOption)
                DropdownMenu(
                    expanded = expandedCategory,
                    onDismissRequest = { expandedCategory = false }) {
                    categoryOptions.forEach { option ->
                        DropdownMenuItem(text = {
                            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .background(Color(0xFFFFA500))
                                ) // Orange color box
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = option)
                            }
                        }, onClick = {
                            selectedCategoryOption = option
                            expandedCategory = false
                        })
                    }
                }
            }
        }
    }
}

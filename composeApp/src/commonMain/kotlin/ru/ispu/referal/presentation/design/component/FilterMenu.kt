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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterMenu(
    expanded: Boolean,
    isFull: Boolean = true,
    categoryOptions: Map<String, Boolean> = emptyMap(),
    onChecked: (String) -> Unit = {},
    onDismissRequest: () -> Unit
) {
    var expandedSort by remember { mutableStateOf(false) }
    var expandedCategory by remember { mutableStateOf(false) }
    var selectedSortOption by remember { mutableStateOf("комиссия % ↓") }
    val selectedCategoryOption by remember { mutableStateOf("Укажите компании") }

    val sortOptions = listOf("цена ↑", "цена ↓", "комиссия % ↑", "комиссия % ↓")


    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = Modifier.width(500.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Sort Drop Down
            Text(
                text = "Сортировка",
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

            if (isFull) {
                Spacer(modifier = Modifier.height(16.dp))

                // Category Drop Down
                /*Text(
                    text = "Компания",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(8.dp))
                */
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
                                    Checkbox(
                                        option.value,
                                        onCheckedChange = {
                                            onChecked(option.key)
                                        }
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = option.key)
                                }
                            }, onClick = {
                                onChecked(option.key)
                            })
                        }
                    }
                }
            }

        }
    }
}

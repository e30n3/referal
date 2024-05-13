package ru.ispu.referal.presentation.screen.common.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Pending
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun ProfileScreen() {
    ViewModel(factory = { ProfileViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                ProfileAction.NavigateBack -> rootController.popBackStack()
                ProfileAction.NavigateToSplash -> rootController.launch(
                    NavDestinations.Splash.Splash.name,
                    launchFlag = LaunchFlag.SingleNewTask,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(state: ProfileState, eventHandler: (ProfileEvent) -> Unit) {
    Column {
        TopAppBar(title = { Text("Профиль") }, navigationIcon = {
            IconButton({ eventHandler(ProfileEvent.BackClicked) }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        })
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp)) {
            OutlinedTextField(
                value = state.name,
                onValueChange = { eventHandler(ProfileEvent.NameChanged(it)) },
                label = { Text("Отображаемое название") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.email,
                onValueChange = { eventHandler(ProfileEvent.EmailChanged(it)) },
                label = { Text("Электроннй адрес") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.password,
                onValueChange = { eventHandler(ProfileEvent.PasswordChanged(it)) },
                label = { Text("Пароль") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Password, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.height(16.dp))
            Card {
                Column(Modifier.padding(16.dp).fillMaxWidth()) {
                    Text("Статистика", style = MaterialTheme.typography.headlineSmall)
                    Text(
                        "${state.accountStat?.total} рефералов:",
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(Icons.Default.CheckCircle, null)
                        Text(
                            "${state.accountStat?.success} успешных",
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(Icons.Default.Pending, null)
                        Text(
                            "${state.accountStat?.inProcess} в процессе",
                        )
                    }
                }
            }

        }
        Column(Modifier.padding(vertical = 4.dp)) {
            Button(
                onClick = { eventHandler(ProfileEvent.SaveClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Сохранить")
            }
            OutlinedButton(
                onClick = { eventHandler(ProfileEvent.LogoutClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Выйти")
            }
        }
    }
}
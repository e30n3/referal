package ru.ispu.referal.presentation.screen.company.companyProfile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun CompanyProfileScreen() {
    ViewModel(factory = { CompanyProfileViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                CompanyProfileAction.NavigateBack -> rootController.popBackStack()
                CompanyProfileAction.NavigateToSplash -> rootController.launch(
                    NavDestinations.Splash.Splash.name,
                    launchFlag = LaunchFlag.SingleNewTask,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(state: CompanyProfileState, eventHandler: (CompanyProfileEvent) -> Unit) {
    Column {
        TopAppBar(title = { Text("Профиль") }, navigationIcon = {
            IconButton({ eventHandler(CompanyProfileEvent.BackClicked) }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        })
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp)) {
            OutlinedTextField(
                value = state.name,
                onValueChange = { eventHandler(CompanyProfileEvent.NameChanged(it)) },
                label = { Text("Отображаемое название") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.email,
                onValueChange = { eventHandler(CompanyProfileEvent.EmailChanged(it)) },
                label = { Text("Электроннй адрес") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.password,
                onValueChange = { eventHandler(CompanyProfileEvent.PasswordChanged(it)) },
                label = { Text("Пароль") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Password, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation()
            )
        }
        Column(Modifier.padding(vertical = 4.dp)) {
            Button(
                onClick = { eventHandler(CompanyProfileEvent.SaveClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Сохранить")
            }
            OutlinedButton(
                onClick = { eventHandler(CompanyProfileEvent.LogoutClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Выйти")
            }
        }
    }
}
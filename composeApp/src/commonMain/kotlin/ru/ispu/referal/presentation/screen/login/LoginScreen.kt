package ru.ispu.referal.presentation.screen.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun LoginScreen() {
    ViewModel(factory = { LoginViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                LoginAction.NavigateToCompanyScreen -> rootController.launch(
                    NavDestinations.CompanyMain.Main.name,
                    launchFlag = LaunchFlag.SingleNewTask,
                )
            }
        }
    }
}

@Composable
private fun ScreenContent(state: LoginState, eventHandler: (LoginEvent) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Spacer(Modifier.weight(1f))
        Text("Вход", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = state.login,
            onValueChange = { eventHandler(LoginEvent.LoginChanged(it)) },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }
        )
        OutlinedTextField(
            value = state.password,
            onValueChange = { eventHandler(LoginEvent.PasswordChanged(it)) },
            label = { Text("Пароль") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(onClick = { eventHandler(LoginEvent.PasswordVisibilityClicked) }) {
                    Icon(
                        imageVector = if (state.isPasswordVisible) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            visualTransformation =
            if (state.isPasswordVisible) VisualTransformation.None
            else PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Password, contentDescription = null) }
        )
        AnimatedVisibility(state.isErrorVisible) {
            Text(
                text = "Неверный логин или пароль",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
        Spacer(Modifier.weight(0.5f))
        Button(
            onClick = { eventHandler(LoginEvent.LoginButtonClicked) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Войти")
        }
        OutlinedButton(
            onClick = { eventHandler(LoginEvent.LoginButtonClicked) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Регистрация")
        }
        TextButton(
            onClick = { eventHandler(LoginEvent.LoginButtonClicked) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Восстановить пароль")
        }
    }
}
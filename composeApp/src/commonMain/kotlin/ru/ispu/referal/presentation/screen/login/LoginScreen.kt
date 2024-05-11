package ru.ispu.referal.presentation.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag
import ru.alexgladkov.odyssey.core.animations.AnimationType
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
                is LoginAction.NavigateToLoginScreen -> rootController.launch(
                    NavDestinations.Auth.Login.name,
                    launchFlag = LaunchFlag.SingleNewTask,
                    animationType = AnimationType.Fade(500)
                )
            }
        }
    }
}

@Composable
private fun ScreenContent(state: LoginState, eventHandler: (LoginEvent) -> Unit) {
    Column {
        Text(text = state.titleText)
        Button({ eventHandler.invoke(LoginEvent.IncrementClick) }) {
            Text(text = state.counter.toString())
        }
    }
}
package ru.ispu.referal.presentation.screen.login

data class LoginState(
    val titleText: String = "",
    val counter: Int = 0
)

sealed class LoginEvent {
    data object IncrementClick : LoginEvent()
}

sealed class LoginAction {
    data class NavigateToLoginScreen(val param: Int) : LoginAction()
}


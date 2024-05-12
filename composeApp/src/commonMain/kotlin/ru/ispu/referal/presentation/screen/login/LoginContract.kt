package ru.ispu.referal.presentation.screen.login

data class LoginState(
    val login: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
)

sealed class LoginEvent {
    data object LoginButtonClicked : LoginEvent()

    data object PasswordVisibilityClicked : LoginEvent()
    data class LoginChanged(val newLogin: String) : LoginEvent()
    data class PasswordChanged(val newPassword: String) : LoginEvent()

}

sealed class LoginAction {
    data object NavigateToCompanyScreen : LoginAction()
}


package ru.ispu.referal.presentation.screen.login

data class LoginState(
    val login: String = "info@volvo.com",
    val password: String = "vpass",
    val isPasswordVisible: Boolean = false,
    val isErrorVisible: Boolean = false,
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


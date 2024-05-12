package ru.ispu.referal.presentation.screen.login

import com.adeo.kviewmodel.BaseSharedViewModel

class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {

            LoginEvent.LoginButtonClicked -> viewAction = LoginAction.NavigateToCompanyScreen
            is LoginEvent.LoginChanged ->
                viewState = viewState.copy(login = viewEvent.newLogin)

            is LoginEvent.PasswordChanged ->
                viewState = viewState.copy(password = viewEvent.newPassword)

            LoginEvent.PasswordVisibilityClicked ->
                viewState = viewState.copy(isPasswordVisible = !viewState.isPasswordVisible)
        }
    }

}
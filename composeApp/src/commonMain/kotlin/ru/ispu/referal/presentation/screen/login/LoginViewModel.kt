package ru.ispu.referal.presentation.screen.login

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent
import ru.ispu.referal.domain.reporitory.Repository

class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {

    private val repository: Repository by KoinJavaComponent.inject(Repository::class.java)

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {

            LoginEvent.LoginButtonClicked -> viewModelScope.launch {
                repository.login(login = viewState.login, password = viewState.password).onFailure {
                    viewState = viewState.copy(isErrorVisible = true)
                }.onSuccess {
                    viewAction = if (it.isCompany) LoginAction.NavigateToCompanyScreen
                    else LoginAction.NavigateToAgentScreen
                }
            }

            is LoginEvent.LoginChanged ->
                viewState = viewState.copy(login = viewEvent.newLogin, isErrorVisible = false)


            is LoginEvent.PasswordChanged ->
                viewState = viewState.copy(password = viewEvent.newPassword, isErrorVisible = false)

            LoginEvent.PasswordVisibilityClicked ->
                viewState = viewState.copy(
                    isPasswordVisible = !viewState.isPasswordVisible,
                    isErrorVisible = false
                )
        }
    }

}
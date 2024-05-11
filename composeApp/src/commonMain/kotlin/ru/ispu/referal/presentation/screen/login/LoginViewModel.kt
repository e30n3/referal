package ru.ispu.referal.presentation.screen.login

import com.adeo.kviewmodel.BaseSharedViewModel

class LoginViewModel : BaseSharedViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            LoginEvent.IncrementClick -> viewState =
                viewState.copy(counter = viewState.counter + 1)
        }
    }

}
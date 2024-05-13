package ru.ispu.referal.presentation.screen.common.profile

import ru.ispu.referal.domain.model.Account

data class ProfileState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val account: Account? = null,
)

sealed class ProfileEvent {
    data object BackClicked : ProfileEvent()
    data class NameChanged(val newValue: String) : ProfileEvent()
    data class EmailChanged(val newValue: String) : ProfileEvent()
    data class PasswordChanged(val newValue: String) : ProfileEvent()
    data object SaveClicked : ProfileEvent()
    data object LogoutClicked : ProfileEvent()

}

sealed class ProfileAction {
    data object NavigateBack : ProfileAction()
    data object NavigateToSplash : ProfileAction()

}


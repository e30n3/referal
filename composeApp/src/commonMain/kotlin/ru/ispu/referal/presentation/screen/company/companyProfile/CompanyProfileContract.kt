package ru.ispu.referal.presentation.screen.company.companyProfile

data class CompanyProfileState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
)

sealed class CompanyProfileEvent {
    data object BackClicked : CompanyProfileEvent()
    data class NameChanged(val newValue: String) : CompanyProfileEvent()
    data class EmailChanged(val newValue: String) : CompanyProfileEvent()
    data class PasswordChanged(val newValue: String) : CompanyProfileEvent()
    data object SaveClicked : CompanyProfileEvent()
    data object LogoutClicked : CompanyProfileEvent()

}

sealed class CompanyProfileAction {
    data object NavigateBack : CompanyProfileAction()
    data object NavigateToSplash : CompanyProfileAction()

}


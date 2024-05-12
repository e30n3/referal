package ru.ispu.referal.presentation.screen.company.companyProfile

data class CompanyProfileState(
    val text: String = "",
)

sealed class CompanyProfileEvent {
    data object BackClicked : CompanyProfileEvent()

    data object CompanyProfileButtonClicked : CompanyProfileEvent()

}

sealed class CompanyProfileAction {
    data object NavigateBack : CompanyProfileAction()
}


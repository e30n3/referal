package ru.ispu.referal.presentation.screen.company.companyHome

import ru.ispu.referal.domain.model.Offer

data class CompanyHomeState(
    val text: String = "Company Home",
    val offers: List<Offer> = emptyList()
)

sealed class CompanyHomeEvent {
    data object ProfileClicked : CompanyHomeEvent()


}

sealed class CompanyHomeAction {
    data object NavigateToCompanyProfile : CompanyHomeAction()
}


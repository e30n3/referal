package ru.ispu.referal.presentation.screen.company.companyHome

import ru.ispu.referal.domain.model.Offer

data class CompanyHomeState(
    val text: String = "Company Home",
    val offers: List<Offer> = emptyList()
)

sealed class CompanyHomeEvent {
    data object ProfileClicked : CompanyHomeEvent()
    data class OfferClicked(val offer: Offer) : CompanyHomeEvent()
    data object NewOfferClicked : CompanyHomeEvent()

}

sealed class CompanyHomeAction {
    data object NavigateToCompanyProfile : CompanyHomeAction()
    data class NavigateToCompanyOffer(val offer: Offer? = null) : CompanyHomeAction()
}


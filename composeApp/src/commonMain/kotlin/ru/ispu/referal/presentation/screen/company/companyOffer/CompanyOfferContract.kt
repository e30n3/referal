package ru.ispu.referal.presentation.screen.company.companyOffer

data class CompanyOfferState(
    val text: String = "Company Offer",
)

sealed class CompanyOfferEvent {
    data object BackClicked : CompanyOfferEvent()

}

sealed class CompanyOfferAction {
    data object NavigateBack : CompanyOfferAction()

}


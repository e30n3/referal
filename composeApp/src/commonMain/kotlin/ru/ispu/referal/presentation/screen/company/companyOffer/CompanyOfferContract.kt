package ru.ispu.referal.presentation.screen.company.companyOffer

data class CompanyOfferState(
    val imgUrl: String = "",
    val title: String = "",
    val price: String = "",
    val location: String = "",
    val commission: String = "",
)

sealed class CompanyOfferEvent {
    data object BackClicked : CompanyOfferEvent()
    data class ImgUrlChanged(val newValue: String) : CompanyOfferEvent()
    data class TitleChanged(val newValue: String) : CompanyOfferEvent()
    data class PriceChanged(val newValue: String) : CompanyOfferEvent()
    data class LocationChanged(val newValue: String) : CompanyOfferEvent()
    data class CommissionChanged(val newValue: String) : CompanyOfferEvent()

}

sealed class CompanyOfferAction {
    data object NavigateBack : CompanyOfferAction()

}


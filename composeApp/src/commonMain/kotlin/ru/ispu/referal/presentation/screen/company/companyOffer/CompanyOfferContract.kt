package ru.ispu.referal.presentation.screen.company.companyOffer

data class CompanyOfferState(
    val imgUrl: String = "",
    val title: String = "",
    val price: String = "",
    val location: String = "",
    val commission: String = "",
    val description: String = "",
    val isDeleteVisible: Boolean = false,
)

sealed class CompanyOfferEvent {
    data object BackClicked : CompanyOfferEvent()
    data class ImgUrlChanged(val newValue: String) : CompanyOfferEvent()
    data class TitleChanged(val newValue: String) : CompanyOfferEvent()
    data class PriceChanged(val newValue: String) : CompanyOfferEvent()
    data class LocationChanged(val newValue: String) : CompanyOfferEvent()
    data class CommissionChanged(val newValue: String) : CompanyOfferEvent()
    data class DescriptionChanged(val newValue: String) : CompanyOfferEvent()
    data object SaveClicked : CompanyOfferEvent()
    data object DeleteClicked : CompanyOfferEvent()
}

sealed class CompanyOfferAction {
    data object NavigateBack : CompanyOfferAction()

}


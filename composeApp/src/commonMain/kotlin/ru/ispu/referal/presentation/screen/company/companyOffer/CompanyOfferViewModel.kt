package ru.ispu.referal.presentation.screen.company.companyOffer

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.reporitory.Repository

class CompanyOfferViewModel(private val offer: Offer?) :
    BaseSharedViewModel<CompanyOfferState, CompanyOfferAction, CompanyOfferEvent>(CompanyOfferState()) {

    private val repository: Repository by inject(Repository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        repository.getOffers().onSuccess {
            viewState = viewState.copy(
                imgUrl = offer?.imgUrl ?: viewState.imgUrl,
                title = offer?.title ?: viewState.title,
                price = offer?.price ?: viewState.price,
                location = offer?.location ?: viewState.location,
                commission = offer?.commission ?: viewState.commission,
            )
        }.onFailure { it.printStackTrace() }
    }

    override fun obtainEvent(viewEvent: CompanyOfferEvent) {
        when (viewEvent) {
            CompanyOfferEvent.BackClicked -> viewAction = CompanyOfferAction.NavigateBack
            is CompanyOfferEvent.CommissionChanged -> viewState =
                viewState.copy(imgUrl = viewEvent.newValue)

            is CompanyOfferEvent.ImgUrlChanged -> viewState =
                viewState.copy(title = viewEvent.newValue)

            is CompanyOfferEvent.LocationChanged -> viewState =
                viewState.copy(price = viewEvent.newValue)

            is CompanyOfferEvent.PriceChanged -> viewState =
                viewState.copy(location = viewEvent.newValue)

            is CompanyOfferEvent.TitleChanged -> viewState =
                viewState.copy(commission = viewEvent.newValue)
        }
    }

}
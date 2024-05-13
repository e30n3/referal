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
        viewState = if (offer != null) viewState.copy(
            imgUrl = offer.imgUrl,
            title = offer.title,
            price = offer.price,
            location = offer.location,
            commission = offer.commission,
            description = offer.description,
            isDeleteVisible = true
        ) else viewState.copy(isDeleteVisible = false)
    }

    override fun obtainEvent(viewEvent: CompanyOfferEvent) {
        when (viewEvent) {
            CompanyOfferEvent.BackClicked -> viewAction = CompanyOfferAction.NavigateBack
            is CompanyOfferEvent.CommissionChanged -> viewState =
                viewState.copy(commission = viewEvent.newValue)

            is CompanyOfferEvent.ImgUrlChanged -> viewState =
                viewState.copy(imgUrl = viewEvent.newValue)

            is CompanyOfferEvent.LocationChanged -> viewState =
                viewState.copy(location = viewEvent.newValue)

            is CompanyOfferEvent.PriceChanged -> viewState =
                viewState.copy(price = viewEvent.newValue)

            is CompanyOfferEvent.TitleChanged -> viewState =
                viewState.copy(title = viewEvent.newValue)

            is CompanyOfferEvent.DescriptionChanged -> viewState =
                viewState.copy(description = viewEvent.newValue)


            CompanyOfferEvent.DeleteClicked -> viewModelScope.launch {
                repository.deleteOffer(offer?.id.orEmpty()).onFailure {
                    it.printStackTrace()
                }.onSuccess {
                    viewAction = CompanyOfferAction.NavigateBack
                }
            }

            CompanyOfferEvent.SaveClicked -> viewModelScope.launch {
                (offer?.copy(
                    imgUrl = viewState.imgUrl,
                    title = viewState.title,
                    price = viewState.price,
                    location = viewState.location,
                    commission = viewState.commission,
                    description = viewState.description
                ) ?: Offer(
                    imgUrl = viewState.imgUrl,
                    title = viewState.title,
                    price = viewState.price,
                    location = viewState.location,
                    commission = viewState.commission,
                    description = viewState.description,
                    company = repository.getCurrentAccount()?.name.orEmpty()
                )).let {
                    repository.updateOffer(it)
                        .onFailure { e ->
                            e.printStackTrace()
                        }.onSuccess {
                            viewAction = CompanyOfferAction.NavigateBack
                        }
                }
            }

        }
    }

}
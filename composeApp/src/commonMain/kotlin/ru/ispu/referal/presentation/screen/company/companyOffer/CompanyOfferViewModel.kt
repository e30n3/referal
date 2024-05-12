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
        /* repository.getOffers().onSuccess {
             viewState = viewState.copy(offers = it)
         }.onFailure { it.printStackTrace() }*/
    }

    override fun obtainEvent(viewEvent: CompanyOfferEvent) {
        when (viewEvent) {
            CompanyOfferEvent.BackClicked -> viewAction = CompanyOfferAction.NavigateBack
        }
    }

}
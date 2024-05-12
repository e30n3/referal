package ru.ispu.referal.presentation.screen.company.companyHome

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.reporitory.Repository

class CompanyHomeViewModel :
    BaseSharedViewModel<CompanyHomeState, CompanyHomeAction, CompanyHomeEvent>(CompanyHomeState()) {

    private val repository: Repository by inject(Repository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        repository.getOffers().onSuccess {
            viewState = viewState.copy(offers = it)
        }.onFailure { it.printStackTrace() }
    }

    override fun obtainEvent(viewEvent: CompanyHomeEvent) {
        when (viewEvent) {
            CompanyHomeEvent.ProfileClicked -> viewAction =
                CompanyHomeAction.NavigateToCompanyProfile

            is CompanyHomeEvent.OfferClicked -> viewAction =
                CompanyHomeAction.NavigateToCompanyOffer(viewEvent.offer)

            CompanyHomeEvent.NewOfferClicked -> viewAction =
                CompanyHomeAction.NavigateToCompanyOffer()
        }
    }

}
package ru.ispu.referal.presentation.screen.company.companyReferralDetail

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.reporitory.Repository

class CompanyReferralDetailViewModel(private val referral: Referral?) :
    BaseSharedViewModel<CompanyReferralDetailState, CompanyReferralDetailAction, CompanyReferralDetailEvent>(
        CompanyReferralDetailState()
    ) {

    private val repository: Repository by inject(Repository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        viewState = viewState.copy(referral = referral)
    }

    override fun obtainEvent(viewEvent: CompanyReferralDetailEvent) {
        when (viewEvent) {
            CompanyReferralDetailEvent.BackClicked -> viewAction =
                CompanyReferralDetailAction.NavigateBack

        }
    }

}
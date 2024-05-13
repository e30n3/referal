package ru.ispu.referal.presentation.screen.company.companyReferral

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.reporitory.Repository

class CompanyReferralViewModel :
    BaseSharedViewModel<CompanyReferralState, CompanyReferralAction, CompanyReferralEvent>(
        CompanyReferralState()
    ) {

    private val repository: Repository by inject(Repository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        repository.getReferrals(repository.getCurrentAccount()?.id).onSuccess {
            viewState = viewState.copy(referrals = it)
        }.onFailure { it.printStackTrace() }
    }

    override fun obtainEvent(viewEvent: CompanyReferralEvent) {
        when (viewEvent) {
            is CompanyReferralEvent.ReferralClicked -> viewAction =
                CompanyReferralAction.NavigateToReferralDetail(viewEvent.referral)

        }
    }

}
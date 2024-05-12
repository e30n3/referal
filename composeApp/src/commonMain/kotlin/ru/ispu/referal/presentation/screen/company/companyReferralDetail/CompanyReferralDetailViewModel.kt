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

            CompanyReferralDetailEvent.NextClicked -> viewModelScope.launch {
                referral?.id?.let { repository.updateStatus(it) }?.onFailure {
                    it.printStackTrace()
                }?.onSuccess {
                    viewState = viewState.copy(referral = it)
                }
            }

            CompanyReferralDetailEvent.RejectClicked -> viewModelScope.launch {
                referral?.id?.let { repository.rejectStatus(it) }
                    ?.onFailure {
                        it.printStackTrace()
                    }?.onSuccess {
                        viewState = viewState.copy(referral = it)
                    }
            }

            is CompanyReferralDetailEvent.AmountChanged ->
                viewState = viewState.copy(amount = viewEvent.amount)

            CompanyReferralDetailEvent.NextClickedWithAmount -> viewModelScope.launch {
                referral?.id?.let { repository.updateStatus(it, viewState.amount.toIntOrNull()) }
                    ?.onFailure {
                        it.printStackTrace()
                    }?.onSuccess {
                        viewState = viewState.copy(referral = it)
                    }
            }
        }
    }


}
package ru.ispu.referal.presentation.screen.agent.agentReferral

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.reporitory.Repository

class AgentReferralViewModel :
    BaseSharedViewModel<AgentReferralState, AgentReferralAction, AgentReferralEvent>(
        AgentReferralState()
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

    override fun obtainEvent(viewEvent: AgentReferralEvent) {
        when (viewEvent) {
            is AgentReferralEvent.ReferralClicked -> viewAction =
                AgentReferralAction.NavigateToReferralDetail(viewEvent.referral)

        }
    }

}
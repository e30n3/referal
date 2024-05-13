package ru.ispu.referal.presentation.screen.agent.agentReferralDetail

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.reporitory.Repository

class AgentReferralDetailViewModel(private val referral: Referral?) :
    BaseSharedViewModel<AgentReferralDetailState, AgentReferralDetailAction, AgentReferralDetailEvent>(
        AgentReferralDetailState()
    ) {

    private val repository: Repository by inject(Repository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        viewState = viewState.copy(referral = referral)
    }

    override fun obtainEvent(viewEvent: AgentReferralDetailEvent) {
        when (viewEvent) {
            AgentReferralDetailEvent.BackClicked -> viewAction =
                AgentReferralDetailAction.NavigateBack

            AgentReferralDetailEvent.RequestClicked -> viewModelScope.launch {
                referral?.id?.let { repository.updateStatus(it) }?.onFailure {
                    it.printStackTrace()
                }?.onSuccess {
                    viewState = viewState.copy(referral = it)
                }
            }

            AgentReferralDetailEvent.RejectClicked -> viewModelScope.launch {
                referral?.id?.let { repository.rejectStatus(it) }
                    ?.onFailure {
                        it.printStackTrace()
                    }?.onSuccess {
                        viewState = viewState.copy(referral = it)
                    }
            }
        }
    }
}
package ru.ispu.referal.presentation.screen.agent.agentReferralDetail

import ru.ispu.referal.domain.model.Referral

data class AgentReferralDetailState(
    val referral: Referral? = null,
    val amount: String = "",
)

sealed class AgentReferralDetailEvent {
    data object BackClicked : AgentReferralDetailEvent()
    data object RejectClicked : AgentReferralDetailEvent()
    data object RequestClicked : AgentReferralDetailEvent()
}

sealed class AgentReferralDetailAction {
    data object NavigateBack : AgentReferralDetailAction()
}


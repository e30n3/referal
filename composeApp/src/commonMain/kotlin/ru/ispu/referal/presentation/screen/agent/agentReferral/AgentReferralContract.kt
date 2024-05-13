package ru.ispu.referal.presentation.screen.agent.agentReferral

import ru.ispu.referal.domain.model.Referral

data class AgentReferralState(
    val referrals: List<Referral> = emptyList()
)

sealed class AgentReferralEvent {
    data class ReferralClicked(val referral: Referral) : AgentReferralEvent()


}

sealed class AgentReferralAction {
    data class NavigateToReferralDetail(val referral: Referral) : AgentReferralAction()
}


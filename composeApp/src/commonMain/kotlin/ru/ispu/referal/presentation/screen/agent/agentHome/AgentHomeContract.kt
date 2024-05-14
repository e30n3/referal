package ru.ispu.referal.presentation.screen.agent.agentHome

import ru.ispu.referal.domain.model.Offer

data class AgentHomeState(
    val title: String = "",
    val offers: List<Offer> = emptyList(),
    val companies: Map<String, Boolean> = emptyMap()
)

sealed class AgentHomeEvent {
    data object ProfileClicked : AgentHomeEvent()
    data class OfferClicked(val offer: Offer) : AgentHomeEvent()
    data class CompanyChecked(val company: String) : AgentHomeEvent()
}

sealed class AgentHomeAction {
    data object NavigateToAgentProfile : AgentHomeAction()
    data class NavigateToAgentOffer(val offer: Offer? = null) : AgentHomeAction()
}


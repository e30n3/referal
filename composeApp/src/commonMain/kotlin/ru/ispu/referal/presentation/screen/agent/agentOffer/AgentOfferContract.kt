package ru.ispu.referal.presentation.screen.agent.agentOffer

import ru.ispu.referal.domain.model.Offer

data class AgentOfferState(
    val imgUrl: String = "",
    val title: String = "",
    val price: String = "",
    val location: String = "",
    val commission: String = "",
    val description: String = "",
)

sealed class AgentOfferEvent {
    data object BackClicked : AgentOfferEvent()
    data object NewReferralClicked : AgentOfferEvent()
}

sealed class AgentOfferAction {
    data object NavigateBack : AgentOfferAction()
    data class NavigateToNewReferral(val offer: Offer?) : AgentOfferAction()
}


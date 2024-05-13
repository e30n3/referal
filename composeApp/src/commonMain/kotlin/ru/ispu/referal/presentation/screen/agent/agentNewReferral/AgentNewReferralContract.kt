package ru.ispu.referal.presentation.screen.agent.agentNewReferral

data class AgentNewReferralState(
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val comment: String = "",
    val isDeleteVisible: Boolean = false,
)

sealed class AgentNewReferralEvent {
    data object BackClicked : AgentNewReferralEvent()
    data class NameChanged(val newValue: String) : AgentNewReferralEvent()
    data class EmailChanged(val newValue: String) : AgentNewReferralEvent()
    data class PhoneChanged(val newValue: String) : AgentNewReferralEvent()
    data class CommentChanged(val newValue: String) : AgentNewReferralEvent()
    data object SendCLicked : AgentNewReferralEvent()
}

sealed class AgentNewReferralAction {
    data object NavigateBack : AgentNewReferralAction()

}


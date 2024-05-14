package ru.ispu.referal.presentation.screen.agent.agentNewReferral

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.getCurrentDateAsString
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.model.ReferralStatus
import ru.ispu.referal.domain.reporitory.Repository

class AgentNewReferralViewModel(private val offer: Offer?) :
    BaseSharedViewModel<AgentNewReferralState, AgentNewReferralAction, AgentNewReferralEvent>(
        AgentNewReferralState()
    ) {

    private val repository: Repository by inject(Repository::class.java)

    override fun obtainEvent(viewEvent: AgentNewReferralEvent) {
        when (viewEvent) {
            AgentNewReferralEvent.BackClicked -> viewAction = AgentNewReferralAction.NavigateBack
            is AgentNewReferralEvent.CommentChanged -> viewState =
                viewState.copy(comment = viewEvent.newValue)

            is AgentNewReferralEvent.NameChanged -> viewState =
                viewState.copy(name = viewEvent.newValue)

            is AgentNewReferralEvent.PhoneChanged -> viewState =
                viewState.copy(phone = viewEvent.newValue)

            is AgentNewReferralEvent.EmailChanged -> viewState =
                viewState.copy(email = viewEvent.newValue)


            AgentNewReferralEvent.SendCLicked -> viewModelScope.launch {
                repository.addReferral(
                    Referral(
                        client = viewState.name,
                        agent = repository.getCurrentAccount()?.name.orEmpty(),
                        company = offer?.company.orEmpty(),
                        phone = viewState.phone,
                        email = viewState.email,
                        comment = viewState.comment,
                        date = getCurrentDateAsString(),
                        status = ReferralStatus.CREATED,
                        offer = offer?.title.orEmpty(),
                    )
                ).onFailure {
                    it.printStackTrace()
                }.onSuccess {
                    viewAction = AgentNewReferralAction.NavigateBack
                }
            }

        }
    }

}
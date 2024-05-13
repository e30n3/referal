package ru.ispu.referal.presentation.screen.agent.agentOffer

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.reporitory.Repository

class AgentOfferViewModel(private val offer: Offer?) :
    BaseSharedViewModel<AgentOfferState, AgentOfferAction, AgentOfferEvent>(AgentOfferState()) {

    private val repository: Repository by inject(Repository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        if (offer != null) viewState = viewState.copy(
            imgUrl = offer.imgUrl,
            title = offer.title,
            price = offer.price,
            location = offer.location,
            commission = offer.commission,
            description = offer.description,
        )
    }

    override fun obtainEvent(viewEvent: AgentOfferEvent) {
        when (viewEvent) {
            AgentOfferEvent.BackClicked -> viewAction =
                AgentOfferAction.NavigateBack

            AgentOfferEvent.NewReferralClicked -> viewAction =
                AgentOfferAction.NavigateToNewReferral(offer)

        }
    }

}
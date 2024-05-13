package ru.ispu.referal.presentation.screen.agent.agentHome

import com.adeo.kviewmodel.BaseSharedViewModel
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import ru.ispu.referal.domain.reporitory.LoaderStateRepository
import ru.ispu.referal.domain.reporitory.Repository

class AgentHomeViewModel :
    BaseSharedViewModel<AgentHomeState, AgentHomeAction, AgentHomeEvent>(AgentHomeState()) {

    private val repository: Repository by inject(Repository::class.java)
    private val loaderStateRepository: LoaderStateRepository by inject(LoaderStateRepository::class.java)

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        loaderStateRepository.start()
        viewState = viewState.copy(title = repository.getCurrentAccount()?.name.orEmpty())
        repository.getOffers().onSuccess {
            viewState = viewState.copy(offers = it)
        }.onFailure { it.printStackTrace() }
        loaderStateRepository.stop()
    }

    override fun obtainEvent(viewEvent: AgentHomeEvent) {
        when (viewEvent) {
            AgentHomeEvent.ProfileClicked -> viewAction =
                AgentHomeAction.NavigateToAgentProfile

            is AgentHomeEvent.OfferClicked -> viewAction =
                AgentHomeAction.NavigateToAgentOffer(viewEvent.offer)
        }
    }

}
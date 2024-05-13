package ru.ispu.referal.presentation.screen.agent.agentHome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.presentation.design.component.OfferCard
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun AgentHomeScreen() {
    ViewModel(factory = { AgentHomeViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                AgentHomeAction.NavigateToAgentProfile -> rootController
                    .findRootController().push(
                        NavDestinations.Common.Profile.name,
                    )

                is AgentHomeAction.NavigateToAgentOffer -> rootController
                    .findRootController().push(
                        screen = NavDestinations.AgentInner.AgentOffer.name,
                        params = action.offer
                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(state: AgentHomeState, eventHandler: (AgentHomeEvent) -> Unit) {
    Column {
        TopAppBar(title = { Text(state.title) }, actions = {
            IconButton({ }) {
                Icon(Icons.Default.Tune, contentDescription = null)
            }
            Spacer(Modifier.width(4.dp))
            IconButton({ eventHandler(AgentHomeEvent.ProfileClicked) }) {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        })
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(state.offers) {
                OfferCard(
                    imgUrl = it.imgUrl,
                    title = it.title,
                    price = it.price,
                    location = it.location,
                    commission = it.commission,
                    companyLogo = it.companyLogo
                ) { eventHandler(AgentHomeEvent.OfferClicked(it)) }
            }
        }
    }
}
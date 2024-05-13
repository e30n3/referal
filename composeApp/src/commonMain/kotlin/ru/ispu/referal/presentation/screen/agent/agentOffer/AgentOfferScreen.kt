package ru.ispu.referal.presentation.screen.agent.agentOffer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CurrencyRuble
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import com.seiko.imageloader.rememberImagePainter
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun AgentOfferScreen(offer: Offer?) {
    ViewModel(factory = { AgentOfferViewModel(offer) }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                AgentOfferAction.NavigateBack -> rootController.popBackStack()
                is AgentOfferAction.NavigateToNewReferral -> rootController.findRootController()
                    .push(
                        screen = NavDestinations.AgentInner.AgentNewReferral.name,
                        params = action.offer
                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
private fun ScreenContent(state: AgentOfferState, eventHandler: (AgentOfferEvent) -> Unit) {
    Column {
        TopAppBar(title = { Text("Сделка") }, navigationIcon = {
            IconButton({ eventHandler(AgentOfferEvent.BackClicked) }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        })
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp)) {
            val painter = rememberImagePainter(state.imgUrl)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainer),
                /*  contentScale = ContentScale.Crop*/
            )
            Spacer(Modifier.height(16.dp))
            Text(state.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(4.dp))
            FlowRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Card {
                    Row(Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.CurrencyRuble, null)
                        Text(state.price, style = MaterialTheme.typography.labelLarge)
                    }
                }
                Card {
                    Row(Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.LocationOn, null)
                        Text(state.location, style = MaterialTheme.typography.labelLarge)
                    }
                }
                Card {
                    Row(Modifier.padding(4.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Payments, null)
                        Text(state.commission, style = MaterialTheme.typography.labelLarge)
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(state.description)
        }
        Column(Modifier.padding(vertical = 4.dp)) {
            Button(
                onClick = { eventHandler(AgentOfferEvent.NewReferralClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Предложить клиента")
            }
        }
    }
}
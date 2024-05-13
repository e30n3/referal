package ru.ispu.referal.presentation.screen.company.companyReferral

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
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
import ru.ispu.referal.presentation.design.component.ReferralCard
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun CompanyReferralScreen() {
    ViewModel(factory = { CompanyReferralViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                is CompanyReferralAction.NavigateToReferralDetail -> {
                    rootController.findRootController().push(
                        screen = NavDestinations.CompanyInner.CompanyReferralDetail.name,
                        params = action.referral
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(
    state: CompanyReferralState,
    eventHandler: (CompanyReferralEvent) -> Unit
) {
    Column {
        TopAppBar(title = { Text("Рефералы") }, actions = {
            IconButton({ }) {
                Icon(Icons.Default.Tune, contentDescription = null)
            }
        })
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.referrals) {
                ReferralCard(
                    client = it.client,
                    agent = it.agent,
                    date = it.date,
                    status = it.status
                ) {
                    eventHandler(CompanyReferralEvent.ReferralClicked(it))
                }
            }
        }
    }
}
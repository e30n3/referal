package ru.ispu.referal.presentation.screen.company.companyReferralDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.domain.model.Referral

@Composable
fun CompanyReferralDetailScreen(referral: Referral?) {
    ViewModel(factory = { CompanyReferralDetailViewModel(referral) }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                CompanyReferralDetailAction.NavigateBack -> rootController.popBackStack()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(
    state: CompanyReferralDetailState,
    eventHandler: (CompanyReferralDetailEvent) -> Unit
) {
    Column {
        TopAppBar(title = { Text("Реферал") }, navigationIcon = {
            IconButton({ eventHandler(CompanyReferralDetailEvent.BackClicked) }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        })
        Column {
            Text(state.referral.toString())
        }
    }
}
package ru.ispu.referal.presentation.screen.agent.agentNewReferral

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.domain.model.Offer

@Composable
fun AgentNewReferralScreen(offer: Offer?) {
    ViewModel(factory = { AgentNewReferralViewModel(offer) }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                AgentNewReferralAction.NavigateBack -> rootController.popBackStack()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(
    state: AgentNewReferralState,
    eventHandler: (AgentNewReferralEvent) -> Unit
) {
    Column {
        TopAppBar(title = { Text("Новый клиент") }, navigationIcon = {
            IconButton({ eventHandler(AgentNewReferralEvent.BackClicked) }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
            }
        })
        Column(Modifier.weight(1f).verticalScroll(rememberScrollState()).padding(16.dp)) {
            OutlinedTextField(
                value = state.name,
                onValueChange = { eventHandler(AgentNewReferralEvent.NameChanged(it)) },
                label = { Text("Имя и фамилия") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.email,
                onValueChange = { eventHandler(AgentNewReferralEvent.EmailChanged(it)) },
                label = { Text("Эл. почта") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                value = state.phone,
                onValueChange = { eventHandler(AgentNewReferralEvent.PhoneChanged(it)) },
                label = { Text("Телефон") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
            )
            OutlinedTextField(
                value = state.comment,
                onValueChange = { eventHandler(AgentNewReferralEvent.CommentChanged(it)) },
                label = { Text("Комментарий") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.AutoMirrored.Filled.Comment, contentDescription = null) }
            )
        }
        Column(Modifier.padding(vertical = 4.dp)) {
            Button(
                onClick = { eventHandler(AgentNewReferralEvent.SendCLicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Отправить клиента")
            }
        }
    }
}
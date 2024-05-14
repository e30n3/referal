package ru.ispu.referal.presentation.screen.company.companyReferralDetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CurrencyRuble
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.model.ReferralStatus
import ru.ispu.referal.domain.model.ReferralStatus.ACCEPTED
import ru.ispu.referal.domain.model.ReferralStatus.COMPLETED
import ru.ispu.referal.domain.model.ReferralStatus.CREATED
import ru.ispu.referal.domain.model.ReferralStatus.FAILED
import ru.ispu.referal.domain.model.ReferralStatus.IN_PROGRESS
import ru.ispu.referal.domain.model.ReferralStatus.OFFERED
import ru.ispu.referal.domain.model.ReferralStatus.PAYED
import ru.ispu.referal.domain.model.ReferralStatus.PAYING
import ru.ispu.referal.domain.model.ReferralStatus.SIGNED
import ru.ispu.referal.presentation.design.component.ReferalInfoPanel
import ru.ispu.referal.presentation.design.component.ReferralStatusBadge

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
        TopAppBar(
            title = { Text("Реферал для ${state.referral?.offer}") },
            navigationIcon = {
                IconButton({ eventHandler(CompanyReferralDetailEvent.BackClicked) }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                }
            })
        Column(Modifier.verticalScroll(rememberScrollState()).padding(16.dp)) {
            if (state.referral?.status == FAILED) {
                ReferralStatusBadge(state.referral.status, true)
                Spacer(Modifier.height(4.dp))
                ReferalInfoPanel(state.referral) {
                    val isTextVisible = remember { mutableStateOf(false) }
                    Button(
                        onClick = { isTextVisible.value = true },
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Отправить жалобу") }
                    AnimatedVisibility(isTextVisible.value) {
                        Text("Спасибо, ваша жалоба будет рассмотрена!")
                    }
                }
            } else ReferralStatus.entries.drop(1).forEach {
                val isActive = state.referral?.status?.ordinal == it.ordinal
                if (isActive) {
                    Spacer(Modifier.height(8.dp))
                    ReferralStatusBadge(it, true)
                    Spacer(Modifier.height(4.dp))
                    state.referral?.let { ref ->
                        ReferalInfoPanel(
                            referral = ref,
                            isHide = state.referral.status == CREATED
                        ) {
                            when (state.referral.status) {
                                FAILED -> {}

                                CREATED, ACCEPTED, IN_PROGRESS, OFFERED -> DefaultButtonColumn(
                                    onAccept = { eventHandler(CompanyReferralDetailEvent.NextClicked) },
                                    onReject = { eventHandler(CompanyReferralDetailEvent.RejectClicked) }
                                )

                                SIGNED -> Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                    OutlinedTextField(
                                        value = state.amount,
                                        onValueChange = { newAmount ->
                                            eventHandler(
                                                CompanyReferralDetailEvent.AmountChanged(newAmount)
                                            )
                                        },
                                        label = { Text("Комиссия, ₽") },
                                        modifier = Modifier.fillMaxWidth(),
                                        trailingIcon = {
                                            IconButton(onClick = {
                                                eventHandler(
                                                    CompanyReferralDetailEvent.NextClickedWithAmount
                                                )
                                            }) {
                                                Icon(
                                                    imageVector = Icons.Filled.Done,
                                                    contentDescription = null
                                                )
                                            }
                                        },
                                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                                    )
                                    OutlinedButton(
                                        onClick = { eventHandler(CompanyReferralDetailEvent.RejectClicked) },
                                        modifier = Modifier.fillMaxWidth()
                                    ) { Text("Провалено") }
                                }

                                COMPLETED -> Row {
                                    Icon(Icons.Default.CurrencyRuble, contentDescription = null)
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        text = state.referral.amount.toString(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }

                                PAYING -> Column {
                                    Row {
                                        Icon(Icons.Default.CurrencyRuble, contentDescription = null)
                                        Spacer(Modifier.width(8.dp))
                                        Text(
                                            text = state.referral.amount.toString(),
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                    Button(
                                        onClick = { eventHandler(CompanyReferralDetailEvent.NextClicked) },
                                        modifier = Modifier.fillMaxWidth()
                                    ) { Text("Подтвердить выплату") }
                                }

                                PAYED -> Row {
                                    Icon(Icons.Default.CurrencyRuble, contentDescription = null)
                                    Spacer(Modifier.width(8.dp))
                                    Text(
                                        text = state.referral.amount.toString(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                } else ReferralStatusBadge(it, false)
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun DefaultButtonColumn(onAccept: () -> Unit, onReject: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = onAccept,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Подтвердить") }
        OutlinedButton(
            onClick = onReject,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Провалено") }
    }
}
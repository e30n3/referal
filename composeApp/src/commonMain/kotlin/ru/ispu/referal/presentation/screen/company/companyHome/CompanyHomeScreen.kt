package ru.ispu.referal.presentation.screen.company.companyHome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.presentation.design.component.FilterMenu
import ru.ispu.referal.presentation.design.component.OfferCard
import ru.ispu.referal.presentation.navigation.NavDestinations

@Composable
fun CompanyHomeScreen() {
    ViewModel(factory = { CompanyHomeViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                CompanyHomeAction.NavigateToCompanyProfile -> rootController
                    .findRootController().push(
                        NavDestinations.Common.Profile.name,
                    )

                is CompanyHomeAction.NavigateToCompanyOffer -> rootController
                    .findRootController().push(
                        screen = NavDestinations.CompanyInner.CompanyOffer.name,
                        params = action.offer
                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(state: CompanyHomeState, eventHandler: (CompanyHomeEvent) -> Unit) {
    Column {
        var expanded by remember { mutableStateOf(false) }
        TopAppBar(title = { Text(state.title) }, actions = {
            IconButton({ expanded = true }) {
                Icon(Icons.Default.Tune, contentDescription = null)
            }
            FilterMenu(expanded, false) { expanded = false }
            Spacer(Modifier.width(4.dp))
            IconButton({ eventHandler(CompanyHomeEvent.ProfileClicked) }) {
                Icon(Icons.Default.Person, contentDescription = null)
            }
        })
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
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
                ) { eventHandler(CompanyHomeEvent.OfferClicked(it)) }
            }
        }
        Button(
            onClick = { eventHandler(CompanyHomeEvent.NewOfferClicked) },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)
        ) {
            Text("Добавить программу")
        }
    }
}
package ru.ispu.referal.presentation.screen.company.companyOffer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Title
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.ViewModel
import com.adeo.kviewmodel.compose.observeAsState
import com.seiko.imageloader.rememberImagePainter
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.ispu.referal.domain.model.Offer

@Composable
fun CompanyOfferScreen(offer: Offer?) {
    ViewModel(factory = { CompanyOfferViewModel(offer) }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()
        val rootController = LocalRootController.current
        ScreenContent(viewState.value) { viewModel.obtainEvent(it) }
        viewAction.value?.let { action ->
            when (action) {
                CompanyOfferAction.NavigateBack -> rootController.popBackStack()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(state: CompanyOfferState, eventHandler: (CompanyOfferEvent) -> Unit) {
    Column {
        TopAppBar(title = { Text("Сделка") }, navigationIcon = {
            IconButton({ eventHandler(CompanyOfferEvent.BackClicked) }) {
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
                    .height(128.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.surfaceContainer),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                value = state.imgUrl,
                onValueChange = { eventHandler(CompanyOfferEvent.ImgUrlChanged(it)) },
                label = { Text("Ссылка изображения") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Link, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.title,
                onValueChange = { eventHandler(CompanyOfferEvent.TitleChanged(it)) },
                label = { Text("Название") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Title, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.price,
                onValueChange = { eventHandler(CompanyOfferEvent.PriceChanged(it)) },
                label = { Text("Цена") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.CurrencyRuble, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.location,
                onValueChange = { eventHandler(CompanyOfferEvent.LocationChanged(it)) },
                label = { Text("Место") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.commission,
                onValueChange = { eventHandler(CompanyOfferEvent.CommissionChanged(it)) },
                label = { Text("Комиссия") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Percent, contentDescription = null) }
            )
            OutlinedTextField(
                value = state.description,
                onValueChange = { eventHandler(CompanyOfferEvent.DescriptionChanged(it)) },
                label = { Text("Описание") },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Description, contentDescription = null) }
            )

        }
        Column(Modifier.padding(vertical = 4.dp)) {
            Button(
                onClick = { eventHandler(CompanyOfferEvent.SaveClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Сохранить")
            }
            if (state.isDeleteVisible) OutlinedButton(
                onClick = { eventHandler(CompanyOfferEvent.DeleteClicked) },
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
            ) {
                Text("Удалить")
            }
        }
    }
}
package ru.ispu.referal.presentation.design.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberImagePainter

/*@Composable
fun OfferCard(
    imgUrl: String,
    title: String,
    price: String,
    location: String,
    commission: String,
    modifier: Modifier = Modifier,
) {
    Card(modifier) {
        val painter = rememberImagePainter(imgUrl)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(128.dp),
            contentScale = ContentScale.Crop,
        )
        Text(title)
        Text(price)
        Text(location)
        Text(commission)
    }
}*/

@Composable
fun OfferCard(
    imgUrl: String,
    title: String,
    price: String,
    location: String,
    commission: String,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth()) {
            val painter = rememberImagePainter(imgUrl)
            Image(
                painter = painter,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = price,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 16.sp
                )
                Text(
                    text = location,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = commission,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 12.sp
                )
            }
        }
    }
}
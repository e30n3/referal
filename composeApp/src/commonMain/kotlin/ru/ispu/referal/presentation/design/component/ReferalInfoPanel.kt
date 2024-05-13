package ru.ispu.referal.presentation.design.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Comment
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.ispu.referal.domain.model.Referral

@Composable
fun ReferalInfoPanel(
    referral: Referral,
    isHide: Boolean = false,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    val clipboard = LocalClipboardManager.current
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = referral.client,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(Modifier.height(8.dp))
            if (!isHide) {
                Row {
                    Icon(Icons.Default.Phone, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(text = referral.phone, style = MaterialTheme.typography.bodyMedium)
                }
                Spacer(Modifier.height(4.dp))
                Row {
                    Icon(Icons.Default.Email, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(text = referral.email, style = MaterialTheme.typography.bodyMedium)
                }
            } else {
                val isTextVisible = remember { mutableStateOf(false) }
                Row(
                    Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .clickable {
                            clipboard.setText(AnnotatedString(referral.phoneHash))
                            isTextVisible.value = true
                        }
                ) {
                    Icon(Icons.Default.Tag, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text(text = referral.phoneHash, style = MaterialTheme.typography.bodyMedium)
                }
                AnimatedVisibility(isTextVisible.value) {
                    Text("Скопировано!", style = MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(Modifier.height(4.dp))
            Row {
                Icon(Icons.AutoMirrored.Filled.Comment, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(text = referral.comment, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.height(4.dp))
            content()
        }
    }
}
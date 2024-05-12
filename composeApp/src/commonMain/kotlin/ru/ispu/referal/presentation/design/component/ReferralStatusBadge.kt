package ru.ispu.referal.presentation.design.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.ispu.referal.domain.model.ReferralStatus

@Composable
fun ReferralStatusBadge(
    referalStatus: ReferralStatus,
    isActive: Boolean = true,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .then(
                if (isActive) Modifier.background(
                    brush = referalStatus.bgGradient,
                    shape = RoundedCornerShape(50)
                ) else Modifier.border(
                    BorderStroke(2.dp, referalStatus.bgGradient),
                    shape = RoundedCornerShape(50)
                )
            )
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Text(
            text = referalStatus.text,
            style = MaterialTheme.typography.bodySmall,
            color = if (isActive) referalStatus.textColor else Color.Unspecified
        )
    }
}
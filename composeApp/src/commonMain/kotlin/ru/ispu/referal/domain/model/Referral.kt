package ru.ispu.referal.domain.model

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class Referral(
    val client: String,
    val agent: String,
    val phone: String,
    val email: String,
    val comment: String,
    val date: String,
    val status: ReferralStatus
)

enum class ReferralStatus(val text: String, val bgGradient: Brush, val textColor: Color) {
    FAILED(
        text = "Failed Deal",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFFFCDD2), Color(0xFFEF9A9A))),
        textColor = Color(0xFFD32F2F)
    ),

    CREATED(
        text = "Реферал создан",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFE0E0E0), Color(0xFFF5F5F5))),
        textColor = Color(0xFF757575)
    ),
    ACCEPTED(
        text = "Реферал подтвержден",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFB2DFDB), Color(0xFFE0F2F1))),
        textColor = Color(0xFF00796B)
    ),
    IN_PROGRESS(
        text = "Контакт с клиентом",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFB3E5FC), Color(0xFFE1F5FE))),
        textColor = Color(0xFF01579B)
    ),
    OFFERED(
        text = "Предложение сделано",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFFFE0B2), Color(0xFFFFF3E0))),
        textColor = Color(0xFFF57C00)
    ),
    SIGNED(
        text = "Договор подписан",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFBBDEFB), Color(0xFFE3F2FD))),
        textColor = Color(0xFF1E88E5)
    ),
    COMPLETED(
        text = "Сделка завершена",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFCE93D8), Color(0xFFEDE7F6))),
        textColor = Color(0xFF6A1B9A)
    ),
    PAYING(
        text = "Выплата комиссии",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFFFF176), Color(0xFFFFF9C4))),
        textColor = Color(0xFFFBC02D)
    ),
    PAYED(
        text = "Комиссия выплачена",
        bgGradient = Brush.horizontalGradient(listOf(Color(0xFFA5D6A7), Color(0xFFC8E6C9))),
        textColor = Color(0xFF2E7D32)
    ),
}



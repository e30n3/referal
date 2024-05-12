package ru.ispu.referal.domain.model

data class Offer(
    val imgUrl: String,
    val title: String,
    val price: String,
    val location: String,
    val commission: String,
    val description: String,
)

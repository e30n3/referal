package ru.ispu.referal.domain.model

import java.util.UUID

data class Offer(
    val imgUrl: String,
    val title: String,
    val price: String,
    val location: String,
    val commission: String,
    val description: String,
    val company: String,
    val companyLogo: String,
    val id: String = UUID.randomUUID().toString()
)

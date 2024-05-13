package ru.ispu.referal.domain.model

import ru.ispu.referal.data.defaultData.DefaultAccounts
import java.util.UUID

data class Offer(
    val imgUrl: String,
    val title: String,
    val price: String,
    val location: String,
    val commission: String,
    val description: String,
    val company: String,
    val id: String = UUID.randomUUID().toString()
) {
    val companyId = DefaultAccounts.accounts.find { it.name == company }?.id
    private fun getCompany() = DefaultAccounts.accounts.find { it.id == companyId }

    val companyLogo = getCompany()?.photoUrl
}

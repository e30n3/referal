package ru.ispu.referal.domain.model

data class AccountStat(
    val total: Int,
    val success: Int,
) {
    val inProcess = total - success
}

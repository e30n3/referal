package ru.ispu.referal.domain.model

import java.util.UUID

data class Account(
    val name: String,
    val email: String,
    val password: String,
    val isCompany: Boolean,
    val photoUrl: String? = null,
    val id: String = UUID.randomUUID().toString(),
) {
    val totalReferrals = 12
    val successReferrals = 4
    val progressReferrals = totalReferrals - successReferrals
}

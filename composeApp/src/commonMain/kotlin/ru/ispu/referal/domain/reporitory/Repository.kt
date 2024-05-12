package ru.ispu.referal.domain.reporitory

import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral

interface Repository {

    suspend fun getOffers(): Result<List<Offer>>

    suspend fun getReferrals(): Result<List<Referral>>
}
package ru.ispu.referal.data.repository

import ru.ispu.referal.data.DataSource
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.reporitory.Repository

class RepositoryImpl(private val dataSource: DataSource) : Repository {
    override suspend fun getOffers(): Result<List<Offer>> =
        runCatching { dataSource.getOffers() }

    override suspend fun getReferrals(): Result<List<Referral>> =
        runCatching { dataSource.getReferrals() }

    override suspend fun updateStatus(
        referralId: String,
        amount: Int?
    ): Result<Referral> = runCatching { dataSource.updateStatus(referralId, amount)!! }

    override suspend fun rejectStatus(referralId: String): Result<Referral> =
        runCatching { dataSource.rejectStatus(referralId)!! }
}
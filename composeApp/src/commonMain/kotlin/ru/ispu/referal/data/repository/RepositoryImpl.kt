package ru.ispu.referal.data.repository

import ru.ispu.referal.data.DataSource
import ru.ispu.referal.domain.model.Account
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.reporitory.Repository

class RepositoryImpl(private val dataSource: DataSource) : Repository {

    private var currentAccount: Account? = null
    override suspend fun getOffers(companyId: String?): Result<List<Offer>> =
        runCatching { dataSource.getOffers(companyId) }

    override suspend fun getReferrals(): Result<List<Referral>> =
        runCatching { dataSource.getReferrals() }

    override suspend fun updateStatus(
        referralId: String,
        amount: Int?
    ): Result<Referral> = runCatching { dataSource.updateStatus(referralId, amount)!! }

    override suspend fun rejectStatus(referralId: String): Result<Referral> =
        runCatching { dataSource.rejectStatus(referralId)!! }

    override suspend fun deleteOffer(offerId: String): Result<Unit> =
        runCatching { dataSource.deleteOffer(offerId) }

    override suspend fun updateOffer(offer: Offer): Result<Unit> =
        runCatching { dataSource.updateOffer(offer) }

    override suspend fun login(login: String, password: String): Result<Account> =
        runCatching {
            currentAccount = dataSource.login(email = login, password = password)
            currentAccount!!
        }

    override fun getCurrentAccount(): Account? = currentAccount

    override suspend fun updateProfile(
        name: String,
        email: String,
        password: String
    ): Result<Account> =
        runCatching {
            currentAccount = dataSource.updateProfile(
                name = name,
                email = email,
                password = password,
                oldEmail = currentAccount?.email.orEmpty(),
                oldPassword = currentAccount?.password.orEmpty()
            )!!
            currentAccount!!
        }

    override suspend fun addReferral(referral: Referral): Result<Unit> = runCatching {
        dataSource.addReferral(referral)
    }
}
package ru.ispu.referal.domain.reporitory

import ru.ispu.referal.domain.model.Account
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral

interface Repository {
    suspend fun getOffers(): Result<List<Offer>>
    suspend fun getReferrals(): Result<List<Referral>>
    suspend fun updateStatus(referralId: String, amount: Int? = null): Result<Referral>
    suspend fun rejectStatus(referralId: String): Result<Referral>
    suspend fun deleteOffer(offerId: String): Result<Unit>
    suspend fun updateOffer(offer: Offer): Result<Unit>
    suspend fun login(login: String, password: String): Result<Account>
    fun getCurrentAccount(): Account?
    suspend fun updateProfile(name: String, email: String, password: String): Result<Account>
}
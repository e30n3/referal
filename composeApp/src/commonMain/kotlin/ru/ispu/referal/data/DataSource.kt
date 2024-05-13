package ru.ispu.referal.data

import kotlinx.coroutines.delay
import ru.ispu.referal.data.defaultData.DefaultAccounts
import ru.ispu.referal.data.defaultData.DefaultOffers
import ru.ispu.referal.data.defaultData.DefaultReferrals
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.model.ReferralStatus
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class DataSource {

    private suspend fun <T> withRandomDelay(action: () -> T): T {
        delay(Random.nextLong(100, 500))
        return action()
    }

    private var referrals = DefaultReferrals.referrals

    private var accounts = DefaultAccounts.accounts

    private var offers: List<Offer> = DefaultOffers.offers
    suspend fun getOffers(companyId: String? = null): List<Offer> = withRandomDelay {
        return@withRandomDelay offers
            .filter { if (companyId != null) it.companyId == companyId else true }
            .sortedByDescending { it.price.filter { it.isDigit() }.toIntOrNull() }
            .sortedByDescending { it.commission.filter { it.isDigit() }.toIntOrNull() }
    }

    suspend fun getReferrals(accountId: String? = null): List<Referral> =
        withRandomDelay {
            return@withRandomDelay referrals
                .filter { it.companyId == accountId || it.agentId == accountId }
                .sortedByDescending {
                    LocalDate.parse(
                        it.date,
                        DateTimeFormatter.ofPattern("dd.MM.yyyy")
                    )
                }
        }

    suspend fun updateStatus(referralId: String, amount: Int? = null) = withRandomDelay {
        referrals = referrals.map {
            if (it.id == referralId)
                it.copy(
                    status = ReferralStatus.entries[it.status.ordinal.inc()],
                    amount = amount ?: it.amount
                )
            else it
        }
        return@withRandomDelay referrals.find { it.id == referralId }
    }

    suspend fun rejectStatus(referralId: String) = withRandomDelay {
        referrals = referrals.map {
            if (it.id == referralId) it.copy(status = ReferralStatus.FAILED)
            else it
        }
        return@withRandomDelay referrals.find { it.id == referralId }
    }

    suspend fun login(email: String, password: String) = withRandomDelay {
        accounts.find { it.email == email && it.password == password }
    }

    suspend fun deleteOffer(offerId: String) = withRandomDelay {
        offers = offers.filter { it.id != offerId }
    }

    suspend fun updateOffer(offer: Offer) = withRandomDelay {
        offers = if (offer.id in offers.map { it.id })
            offers.map { if (it.id == offer.id) offer else it }
        else listOf(offer) + offers
    }

    suspend fun updateProfile(
        name: String,
        email: String,
        password: String,
        oldEmail: String,
        oldPassword: String,
    ) = withRandomDelay {
        accounts = accounts.map {
            if (it.email == oldEmail && it.password == oldPassword) it.copy(
                name = name,
                email = email,
                password = password
            ) else it
        }
        accounts.find { it.email == email && it.password == password }
    }

    suspend fun addReferral(referral: Referral) = withRandomDelay {
        referrals = listOf(referral) + referrals
    }

}
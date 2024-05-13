package ru.ispu.referal.data

import kotlinx.coroutines.delay
import ru.ispu.referal.data.defaultData.DefaultAccounts
import ru.ispu.referal.data.defaultData.DefaultOffers
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.model.ReferralStatus
import kotlin.random.Random

class DataSource {


    private suspend fun <T> withRandomDelay(action: () -> T): T {
        delay(Random.nextLong(100, 500))
        return action()
    }

    private val defaultComment =
        "Volvo provides specialized Maecenas elementum ante vel elementum ultrices. Duis luctus aliquet metus, vel fermentum ligula mollis id."


    private var referrals = listOf(
        Referral(
            client = "Виктор М.",
            agent = "Никита М.",
            company = "BMW",
            phone = "+7 912 345-67-89",
            email = "viktor.m@example.com",
            comment = defaultComment,
            date = "14.03.2024",
            status = ReferralStatus.CREATED
        ), Referral(
            client = "Борис В.",
            agent = "Максим Л.",
            company = "Tesla",
            phone = "+7 912 346-67-80",
            email = "boris.v@example.com",
            comment = defaultComment,
            date = "12.03.2024",
            status = ReferralStatus.SIGNED
        ), Referral(
            client = "Елисей Е.",
            agent = "Алексей В.",
            company = "Mercedes-Benz",
            phone = "+7 912 347-67-81",
            email = "elisey.e@example.com",
            comment = defaultComment,
            date = "07.03.2024",
            status = ReferralStatus.IN_PROGRESS
        ), Referral(
            client = "Данил В.",
            agent = "Евгений Е.",
            company = "Volvo",
            phone = "+7 912 348-67-82",
            email = "danil.v@example.com",
            comment = defaultComment,
            date = "01.03.2024",
            status = ReferralStatus.PAYED
        ), Referral(
            client = "Алексей А.",
            agent = "Тимофей Р.",
            company = "BMW",
            phone = "+7 912 349-67-83",
            email = "alexey.a@example.com",
            comment = defaultComment,
            date = "28.02.2024",
            status = ReferralStatus.FAILED
        ), Referral(
            client = "София С.",
            agent = "Лариса И.",
            company = "Mercedes-Benz",
            phone = "+7 912 350-67-84",
            email = "sofia.s@example.com",
            comment = defaultComment,
            date = "15.02.2024",
            status = ReferralStatus.ACCEPTED
        ), Referral(
            client = "Михаил Д.",
            agent = "Анна П.",
            company = "Volvo",
            phone = "+7 912 351-67-85",
            email = "mikhail.d@example.com",
            comment = defaultComment,
            date = "10.02.2024",
            status = ReferralStatus.OFFERED
        ), Referral(
            client = "Ирина Ш.",
            agent = "Сергей Ф.",
            company = "BMW",
            phone = "+7 912 352-67-86",
            email = "irina.s@example.com",
            comment = defaultComment,
            date = "05.02.2024",
            status = ReferralStatus.COMPLETED
        ), Referral(
            client = "Олег Н.",
            agent = "Виктория С.",
            company = "BMW",
            phone = "+7 912 353-67-87",
            email = "oleg.n@example.com",
            comment = defaultComment,
            date = "20.01.2024",
            status = ReferralStatus.PAYING
        )
    )

    private var accounts = DefaultAccounts.accounts

    private var offers: List<Offer> = DefaultOffers.offers
    suspend fun getOffers(companyId: String? = null): List<Offer> = withRandomDelay {
        return@withRandomDelay offers
            .filter { if (companyId != null) it.companyId == companyId else true }
            .sortedByDescending { it.price.filter { it.isDigit() }.toIntOrNull() }
            .sortedByDescending { it.commission.filter { it.isDigit() }.toIntOrNull() }
    }

    suspend fun getReferrals(): List<Referral> =
        withRandomDelay { return@withRandomDelay referrals }

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
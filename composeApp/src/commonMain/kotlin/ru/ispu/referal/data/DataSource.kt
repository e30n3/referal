package ru.ispu.referal.data

import kotlinx.coroutines.delay
import ru.ispu.referal.domain.model.Account
import ru.ispu.referal.domain.model.Offer
import ru.ispu.referal.domain.model.Referral
import ru.ispu.referal.domain.model.ReferralStatus
import kotlin.random.Random

class DataSource {

    private val randomImages = listOf(
        "https://fastly.picsum.photos/id/942/200/200.jpg?hmac=Gh7W-H3ZGmweB9STLwQvq-IHkxrVyawHVTKYxy-u9mA",
        "https://fastly.picsum.photos/id/146/200/200.jpg?hmac=BEfC1fMGgqn0zNUowEDrlnKsAisQSg9rYB7RxuXpTb4",
        "https://fastly.picsum.photos/id/1059/200/200.jpg?hmac=2w4ZTAuYGsSUL-ur3iVQO04H8398XxIaeLEGVBNRSLU",
        "https://fastly.picsum.photos/id/1000/200/200.jpg?hmac=U6gBcO-m8lNXspqhLW17ugDZ1Z3cEcCQj07Wp9Nq7IQ",
        "https://fastly.picsum.photos/id/74/200/200.jpg?hmac=vocZAjFd_aCjJJ-cIS28YxzM2nwLpe_EYBYW95lrzUI",
        "https://fastly.picsum.photos/id/82/200/200.jpg?hmac=ATNAhTLN2dA0KmTzSE5D9XiPe3GMX8uwxpFlhU7U5OY",
        "https://fastly.picsum.photos/id/371/200/200.jpg?hmac=VShu_HdkBA6-hi8lkHlFMbkqxiu0BgA4mvEKoJke228",
        "https://fastly.picsum.photos/id/635/200/200.jpg?hmac=Vm8Tavc31Qax01634w3MOPpNCCfasJG8wnBamSi87T4",
        "https://fastly.picsum.photos/id/432/200/200.jpg?hmac=b4-kxXh_oTpvCBH9hueJurvHDdhy0eYNNba-mO9Q8bU",
        "https://fastly.picsum.photos/id/247/200/200.jpg?hmac=oKt3N5MCdI8hCrzIbokjpVNzUuywbK64CJn1bfRAxbA"
    )

    private val randomImage: String get() = randomImages.random()

    private suspend fun <T> withRandomDelay(action: () -> T): T {
        delay(Random.nextLong(100, 500))
        return action()
    }

    private val defaultComment =
        "Volvo provides specialized Maecenas elementum ante vel elementum ultrices. Duis luctus aliquet metus, vel fermentum ligula mollis id."

    private var offers: List<Offer> = listOf(
        Offer(
            imgUrl = randomImage,
            title = "XC90",
            price = "50,000+",
            location = "Весь мир",
            commission = "1% комиссия",
            description = defaultComment
        ), Offer(
            imgUrl = randomImage,
            title = "XC70",
            price = "45,000+",
            location = "Европа",
            commission = "1% комиссия",
            description = defaultComment
        ), Offer(
            imgUrl = randomImage,
            title = "XD2000",
            price = "70,000+",
            location = "Весь мир",
            commission = "1% комиссия",
            description = defaultComment
        ), Offer(
            imgUrl = randomImage,
            title = "Truck FH",
            price = "100,000+",
            location = "Весь мир",
            commission = "5% комиссия",
            description = defaultComment
        ), Offer(
            imgUrl = randomImage,
            title = "X6",
            price = "250,000+",
            location = "Worldwide",
            commission = "1% комиссия",
            description = defaultComment
        ), Offer(
            imgUrl = randomImage,
            title = "X7",
            price = "45,000+",
            location = "Европа",
            commission = "1% комиссия",
            description = defaultComment
        )
    )

    private var referrals = listOf(
        Referral(
            client = "Виктор М.",
            agent = "Никита М.",
            phone = "+7 912 345-67-89",
            email = "viktor.m@example.com",
            comment = defaultComment,
            date = "14.03.2024",
            status = ReferralStatus.CREATED
        ), Referral(
            client = "Борис В.",
            agent = "Максим Л.",
            phone = "+7 912 346-67-80",
            email = "boris.v@example.com",
            comment = defaultComment,
            date = "12.03.2024",
            status = ReferralStatus.SIGNED
        ), Referral(
            client = "Елисей Е.",
            agent = "Алексей В.",
            phone = "+7 912 347-67-81",
            email = "elisey.e@example.com",
            comment = defaultComment,
            date = "07.03.2024",
            status = ReferralStatus.IN_PROGRESS
        ), Referral(
            client = "Данил В.",
            agent = "Евгений Е.",
            phone = "+7 912 348-67-82",
            email = "danil.v@example.com",
            comment = defaultComment,
            date = "01.03.2024",
            status = ReferralStatus.PAYED
        ), Referral(
            client = "Алексей А.",
            agent = "Тимофей Р.",
            phone = "+7 912 349-67-83",
            email = "alexey.a@example.com",
            comment = defaultComment,
            date = "28.02.2024",
            status = ReferralStatus.FAILED
        ), Referral(
            client = "София С.",
            agent = "Лариса И.",
            phone = "+7 912 350-67-84",
            email = "sofia.s@example.com",
            comment = defaultComment,
            date = "15.03.2024",
            status = ReferralStatus.ACCEPTED
        ), Referral(
            client = "Михаил Д.",
            agent = "Анна П.",
            phone = "+7 912 351-67-85",
            email = "mikhail.d@example.com",
            comment = defaultComment,
            date = "10.03.2024",
            status = ReferralStatus.OFFERED
        ), Referral(
            client = "Ирина Ш.",
            agent = "Сергей Ф.",
            phone = "+7 912 352-67-86",
            email = "irina.s@example.com",
            comment = defaultComment,
            date = "05.03.2024",
            status = ReferralStatus.COMPLETED
        ), Referral(
            client = "Олег Н.",
            agent = "Виктория С.",
            phone = "+7 912 353-67-87",
            email = "oleg.n@example.com",
            comment = defaultComment,
            date = "20.02.2024",
            status = ReferralStatus.PAYING
        )
    )

    private var accounts = listOf(
        Account(
            name = "Volvo",
            email = "info@volvo.com",
            password = "vpass",
            isCompany = true,
        )
    )


    suspend fun getOffers(): List<Offer> = withRandomDelay { return@withRandomDelay offers }

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
        else offers + offer
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

}
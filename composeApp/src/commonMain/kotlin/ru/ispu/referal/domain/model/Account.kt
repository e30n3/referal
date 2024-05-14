package ru.ispu.referal.domain.model

import java.util.UUID
import kotlin.random.Random

data class Account(
    val name: String,
    val email: String,
    val password: String,
    val isCompany: Boolean,
    val photoUrl: String? = null,
    val id: String = UUID.randomUUID().toString(),
) {
    val phoneNumber = generatePhoneNumber()

    companion object {
        fun generatePhoneNumber(): String {
            val countryCode = "+7"
            val operatorCode = "9" + (10 + Random.nextInt(90)).toString().padStart(2, '0')
            val part1 = (100 + Random.nextInt(900)).toString().padStart(3, '0')
            val part2 = (10 + Random.nextInt(90)).toString().padStart(2, '0')
            val part3 = (10 + Random.nextInt(90)).toString().padStart(2, '0')
            return "$countryCode $operatorCode $part1-$part2-$part3"
        }
    }
}

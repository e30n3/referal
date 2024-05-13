package ru.ispu.referal.data.defaultData

import ru.ispu.referal.domain.model.Account

object DefaultAccounts {
    val accounts = listOf(
        Account(
            name = "Volvo",
            email = "info@volvo.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://brandslogos.com/wp-content/uploads/images/large/volvo-logo.png",
        ),
        Account(
            name = "Mercedes-Benz",
            email = "info@mb.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://res.cloudinary.com/dwtrhvjqf/image/upload/v1715618001/VKR/Companies/Mercedes-Benz/Mercedes_Logo.png",
        ),
        Account(
            name = "BMW",
            email = "info@bmw.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://res.cloudinary.com/dwtrhvjqf/image/upload/v1715470556/VKR/Companies/BMW/bmw_logo.png",
        ),
        Account(
            name = "Tesla",
            email = "info@tesla.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://res.cloudinary.com/dwtrhvjqf/image/upload/v1715618204/VKR/Companies/Tesla/Tesla_Logo.png",
        ),
        Account(
            name = "Louis Vuitton",
            email = "info@lv.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://res.cloudinary.com/dwtrhvjqf/image/upload/v1715618770/VKR/Companies/Louis%20Vuitton/LouisVuitton_logo.png",
        ),
        Account(
            name = "VISA",
            email = "info@visa.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://res.cloudinary.com/dwtrhvjqf/image/upload/v1715618709/VKR/Companies/VISA/VISA_logo.png",
        ),
        Account(
            name = "MasterCard",
            email = "info@mc.com",
            password = "vpass",
            isCompany = true,
            photoUrl = "https://res.cloudinary.com/dwtrhvjqf/image/upload/v1715618232/VKR/Companies/Mastercard/Mastercard_logo.png",
        ),


        Account(
            name = "Андрей Б.",
            email = "info@a.com",
            password = "vpass",
            isCompany = false,
        ),
        Account(
            name = "Иван З.",
            email = "info@i.com",
            password = "vpass",
            isCompany = false,
        )
    )
}
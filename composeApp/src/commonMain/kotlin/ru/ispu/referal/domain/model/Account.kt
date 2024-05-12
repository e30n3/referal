package ru.ispu.referal.domain.model

data class Account(
    val name: String,
    val email: String,
    val password: String,
    val isCompany: Boolean,
)

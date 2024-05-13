package ru.ispu.referal.domain

import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Any.toHash256(): String {
    val bytes = this.toString().toByteArray()
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(bytes)
    return digest.fold("") { str, it -> str + "%02x".format(it) }
}


fun getCurrentDateAsString(): String {
    val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val currentDate = Date()
    return dateFormat.format(currentDate)
}
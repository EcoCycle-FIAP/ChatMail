package br.com.fiap.chatmail.backend.model

import java.util.Date

data class Email(
    val emailId: Int? = null,
    val senderEmailAddress: String,
    val senderFullName: String? = null,
    val recipientEmailAddress: String,
    val recipientFullName: String? = null,
    val subject: String,
    val message: String,
    val attachment: String? = null,
    val isFavorite: String = "N",
    val sendedDate: Date = Date()
)
package br.com.fiap.chatmail.backend.model

import java.util.Date

data class Email(
    val emailId: Int,
    val senderEmailAddress: String,
    val senderFullName: String?,
    val recipientEmailAddress: String,
    val recipientFullName: String?,
    val subject: String,
    val message: String,
    val attachment: String?,
    val isFavorite: Boolean,
    val sendedDate: Date
)
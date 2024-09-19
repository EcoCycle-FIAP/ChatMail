package br.com.fiap.chatmail.models

data class Email(
    val senderEmailAddress: String = "",
    val recipientEmailAddress: String = "",
    val subject: String = "",
    val message: String = ""
)

package br.com.fiap.chatmail.models

data class Email(
    val id: String,
    val sender: String,
    val subject: String,
    val body: String,
    val timestamp: String
)

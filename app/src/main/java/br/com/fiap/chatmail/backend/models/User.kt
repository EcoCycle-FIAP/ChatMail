package br.com.fiap.chatmail.backend.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

class EmailAddress private constructor(val value: String) {

    companion object {
        fun create(value: String): EmailAddress? {
            return if (isValidEmail(value)) {
                EmailAddress(value)
            } else {
                null
            }
        }

        private fun isValidEmail(email: String): Boolean {
            // Verifica se o email contém um '@' e pelo menos um '.'
            return email.contains("@") && email.substringAfter("@").contains(".")
        }
    }
}

data class User(
    @BsonId val id: ObjectId,
    val completeName: String,
    val emailAddress: EmailAddress,
    val password: String
)
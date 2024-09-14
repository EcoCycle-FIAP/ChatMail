package br.com.fiap.chatmail.backend.models

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.sql.Date

data class Email(
    @BsonId val id: ObjectId,
    val sender: User,
    val recipient: User,
    val subject: String,
    val content: String,
    val attachment: ByteArray?,
    val isFavorite: Boolean,
    val sendedDate: Date,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Email

        if (id != other.id) return false
        if (sender != other.sender) return false
        if (recipient != other.recipient) return false
        if (subject != other.subject) return false
        if (content != other.content) return false
        if (attachment != null) {
            if (other.attachment == null) return false
            if (!attachment.contentEquals(other.attachment)) return false
        } else if (other.attachment != null) return false
        if (isFavorite != other.isFavorite) return false
        if (sendedDate != other.sendedDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + sender.hashCode()
        result = 31 * result + recipient.hashCode()
        result = 31 * result + subject.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + (attachment?.contentHashCode() ?: 0)
        result = 31 * result + isFavorite.hashCode()
        result = 31 * result + sendedDate.hashCode()
        return result
    }
}
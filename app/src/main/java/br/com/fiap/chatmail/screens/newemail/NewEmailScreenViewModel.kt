package br.com.fiap.chatmail.screens.newemail

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Properties
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class NewEmailScreenViewModel(private val context: Context) : ViewModel() {

    private val _to = MutableLiveData<String>()
    val to: LiveData<String> = _to

    private val _subject = MutableLiveData<String>()
    val subject: LiveData<String> = _subject

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _successMessage = MutableLiveData<String?>()
    val successMessage: LiveData<String?> = _successMessage

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("EmailPrefs", Context.MODE_PRIVATE)

    // Intervalo de tempo em milissegundos (por exemplo, 1 minuto = 60000 ms)
    private val emailSendInterval = 60000L

    // Lista de palavras-chave suspeitas
    private val spamKeywords = listOf("free", "win", "prize", "money", "urgent")

    fun onToChanged(newTo: String) {
        _to.value = newTo
        checkFields()
    }

    fun onSubjectChanged(newSubject: String) {
        _subject.value = newSubject
        checkFields()
    }

    fun onMessageChanged(newMessage: String) {
        _message.value = newMessage
        checkFields()
    }

    fun sendEmail() {
        // Verificar se todos os campos estão preenchidos
        if (_to.value.isNullOrBlank() || _subject.value.isNullOrBlank() || _message.value.isNullOrBlank()) {
            _error.value = "Todos os campos devem ser preenchidos."
            return
        }

        // Verificação de palavras-chave suspeitas
        if (containsSpamKeywords()) {
            _error.value = "O e-mail contém palavras suspeitas e não pode ser enviado."
            return
        }

        if (isSpam()) {
            _error.value = "Você está enviando e-mails muito rapidamente. Tente novamente mais tarde."
            return
        }

        try {
            // Enviar o e-mail via SMTP
            val result = sendEmailWithSMTP(
                to = _to.value!!,
                subject = _subject.value!!,
                message = _message.value!!
            )

            if (result) {
                clearFields()
                _error.value = null
                _successMessage.value = "E-mail enviado com sucesso!"
                updateLastEmailSentTime()  // Atualizar o tempo de envio
            } else {
                _error.value = "Falha ao enviar o e-mail. Tente novamente."
                _successMessage.value = null
            }
        } catch (e: Exception) {
            _error.value = "Ocorreu um erro ao enviar o e-mail: ${e.message}"
            _successMessage.value = null
        }
    }

    private fun clearFields() {
        _to.value = ""
        _subject.value = ""
        _message.value = ""
    }

    private fun checkFields() {
        val to = _to.value.orEmpty()
        val subject = _subject.value.orEmpty()
        val message = _message.value.orEmpty()

        if (to.isBlank() || subject.isBlank() || message.isBlank()) {
            _error.value = "Nenhum dos campos pode estar vazio"
            return
        }
        _error.value = null
    }

    private fun isSpam(): Boolean {
        val lastSentTime = sharedPreferences.getLong("lastEmailSentTime", 0)
        val currentTime = System.currentTimeMillis()

        return (currentTime - lastSentTime) < emailSendInterval
    }

    private fun updateLastEmailSentTime() {
        with(sharedPreferences.edit()) {
            putLong("lastEmailSentTime", System.currentTimeMillis())
            apply()
        }
    }

    private fun sendEmailWithSMTP(to: String, subject: String, message: String): Boolean {
        val properties = Properties().apply {
            put("mail.smtp.host", "smtp.example.com")
            put("mail.smtp.port", "587")
            put("mail.smtp.auth", "true")
            put("mail.smtp.starttls.enable", "true")
        }

        val session = Session.getInstance(properties, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("username", "password")
            }
        })

        return try {
            val mimeMessage = MimeMessage(session).apply {
                setFrom(InternetAddress("from@example.com"))
                addRecipient(Message.RecipientType.TO, InternetAddress(to))
                setSubject(subject)
                setText(message)
            }
            Transport.send(mimeMessage)
            true
        } catch (e: MessagingException) {
            false
        }
    }

    private fun containsSpamKeywords(): Boolean {
        val subject = _subject.value.orEmpty().toLowerCase()
        val message = _message.value.orEmpty().toLowerCase()

        return spamKeywords.any { keyword ->
            subject.contains(keyword) || message.contains(keyword)
        }
    }
}

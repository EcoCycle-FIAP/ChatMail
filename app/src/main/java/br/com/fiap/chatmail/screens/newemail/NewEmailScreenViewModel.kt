package br.com.fiap.chatmail.screens.newemail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewEmailScreenViewModel : ViewModel() {
    private val _to = MutableLiveData<String>()
    val to: LiveData<String> = _to

    private val _subject = MutableLiveData<String>()
    val subject: LiveData<String> = _subject

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

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

    private fun checkFields() {
        val to = _to.value.orEmpty()
        val subject = _subject.value.orEmpty()
        val message = _message.value.orEmpty()

        //empty fields
        if (to.isBlank() || subject.isBlank() || message.isBlank()) {
            _error.value = "Nenhum dos campos pode estar vazio"
            return
        }
        _error.value = null
    }
}
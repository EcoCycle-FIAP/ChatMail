package br.com.fiap.chatmail.screens.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInScreenViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        checkFields()
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
        checkFields()
    }

    private fun checkFields() {
        val email = _email.value.orEmpty()
        val password = _password.value.orEmpty()

        //empty fields
        if (email.isBlank() || password.isBlank()) {
            _error.value = "Nenhum dos campos pode estar vazio"
            return
        }

        _error.value = null

    }

}
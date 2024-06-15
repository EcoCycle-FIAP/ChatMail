package br.com.fiap.chatmail.screens.signupandsignin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpScreenViewModel : ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _passwordConfirmation = MutableLiveData<String>()
    val passwordConfirmation: LiveData<String> = _passwordConfirmation

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    fun onNameChanged(newName: String) {
        _name.value = newName
        checkFields()
    }

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        checkFields()
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
        checkFields()
    }

    fun onPasswordConfirmationChanged(newPasswordConfirmation: String) {
        _passwordConfirmation.value = newPasswordConfirmation
        checkFields()
    }

    private fun checkFields() {
        val name = _name.value.orEmpty()
        val email = _email.value.orEmpty()
        val password = _password.value.orEmpty()
        val passwordConfirmation = _passwordConfirmation.value.orEmpty()

        //empty fields
        if (name.isBlank() || email.isBlank() || password.isBlank() || passwordConfirmation.isBlank()) {
            _error.value = "Nenhum dos campos pode estar vazio"
            return
        }

        //1 last name
        if (!name.contains(" ")) {
            _error.value = "O nome precisa ter ao menos 1 sobrenome"
            return
        }

        //email format
        if (!email.contains("@") || !email.contains(".com")) {
            _error.value = "O email precisa ser válido"
            return
        }

        //password rules
        if (password.length !in 8..20 || !password.any { it.isLetter() } || !password.any { it.isDigit() }) {
            _error.value =
                "A Senha precisa ter entre 8 a 20 caracteres, contendo ao menos uma letra e um número"
            return
        }

        if (password != passwordConfirmation) {
            _error.value = "As senhas são diferentes"
            return
        }

        _error.value = null

    }

}
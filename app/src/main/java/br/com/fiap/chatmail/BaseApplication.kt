package br.com.fiap.chatmail

import android.app.Application
import androidx.compose.runtime.mutableStateOf

class BaseApplication : Application(){

    val isDark = mutableStateOf(false)

    fun toggleLightTheme(){
        isDark.value = !isDark.value
    }
}
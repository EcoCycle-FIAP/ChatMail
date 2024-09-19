package br.com.fiap.consultacep.service

import br.com.fiap.chatmail.services.EmailService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "http://localhost:3000/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getEmailService(): EmailService {
        return retrofitFactory.create(EmailService::class.java)
    }

}
package br.com.fiap.chatmail.services

import br.com.fiap.chatmail.models.Email
import retrofit2.Call
import retrofit2.http.GET

interface EmailService {
    @GET("emails/list")
    fun listEmails(): Call<List<Email>>

    @GET("emails/favoritos")
    fun listFavoritedEmails(): Call<List<Email>>
}

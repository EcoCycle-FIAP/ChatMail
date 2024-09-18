package br.com.fiap.chatmail.backend.database

import br.com.fiap.chatmail.backend.model.Email
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("emails")
    suspend fun getEmails(): Response<List<Email>>

    @POST("emails")
    suspend fun sendEmail(@Body email: Email): Response<Unit>
}
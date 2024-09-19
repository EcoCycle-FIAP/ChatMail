package br.com.fiap.chatmail.backend.database

import br.com.fiap.chatmail.backend.model.Email
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("emails")
    suspend fun getEmails(): Response<List<Email>>

    @POST("emails")
    suspend fun sendEmail(@Body email: Email): Response<Unit>

    @DELETE("emails/{id}")
    suspend fun deleteEmail(@Path("id") emailId: Int): Response<Unit>
}
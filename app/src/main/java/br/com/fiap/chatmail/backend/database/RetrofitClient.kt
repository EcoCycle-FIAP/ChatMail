package br.com.fiap.chatmail.backend.database

import br.com.fiap.chatmail.backend.model.Email
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.HttpException
import java.io.IOException

object RetrofitClient {
    private const val BASE_URL = "http://localhost:3000/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }

    // Função para fazer a chamada à API e tratar erros
    suspend fun getEmails(): List<Email>? {
        return try {
            val response = instance.getEmails()
            if (response.isSuccessful) {
                response.body()?.also {
                    println("Dados recebidos com sucesso: $it")
                }
            } else {
                // Log de erro caso a resposta não seja bem-sucedida
                println("Erro na resposta: ${response.code()} - ${response.message()}")
                null
            }
        } catch (e: HttpException) {
            println("Erro HTTP: ${e.message}")
            null
        } catch (e: IOException) {
            println("Erro de rede ou conversão: ${e.message}")
            null
        } catch (e: Exception) {
            println("Erro inesperado: ${e.message}")
            null
        }
    }
}

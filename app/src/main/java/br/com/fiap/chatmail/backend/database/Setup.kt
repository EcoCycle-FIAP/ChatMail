package br.com.fiap.chatmail.backend.database

import android.annotation.SuppressLint
import com.mongodb.MongoException
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.runBlocking
import org.bson.BsonInt64
import org.bson.Document


@SuppressLint("AuthLeak")
fun main() {
    val databaseName = "chatmail"

    runBlocking {

        val database = setupConnection(
            databaseName = databaseName,
            "mongodb+srv://chatmailAdmin:MvEbflnHoj7DfRFM@adsfiap.i2sqo.mongodb.net/?retryWrites=true&w=majority&appName=ADSFIAP"

            // A URI de conexão está "chumbada" para permitir rodar o projeto sem precisar configurar uma variável de ambiente. Em uma aplicação real, isso não seria feito pois pode trazer riscos de segurança.
        )

        if (database != null) {
            listAllCollection(database = database)
        }
    }
}

@SuppressLint("AuthLeak")
suspend fun setupConnection(
    databaseName: String = "chatmail", connectionURI: String
): MongoDatabase? {

    val client = MongoClient.create(connectionString = connectionURI)
    val database = client.getDatabase(databaseName = databaseName)

    return try {
        // Envia um ping para confirmar uma conexão bem sucedida
        val command = Document("ping", BsonInt64(1))
        database.runCommand(command)
        println("Pingou seu deployment. Você se conectou com sucesso ao MongoDB!")
        database
    } catch (me: MongoException) {
        System.err.println(me)
        println("Algo deu errado! A conexão ao banco de dados MongoDB não foi bem sucedida.")
        null
    }
}

suspend fun listAllCollection(database: MongoDatabase) {
    print("As coleções nesse banco de dados são:")
    database.listCollectionNames().collect { println(" $it") }
}

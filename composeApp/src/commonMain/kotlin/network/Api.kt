package network

import data.RequestBody
import data.ResponseBody
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class Api {
    companion object {
        val instance = Api()
    }

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun generateProperties(prompt: String): ResponseBody {
        val response = client.post("https://create-2chqcmsfka-uc.a.run.app/") {
            contentType(ContentType.Application.Json)
            setBody(RequestBody.create(
                theme = prompt
            ))
        }
        print("Response: ${response.body<String>()}")
        return response.body()
    }
}
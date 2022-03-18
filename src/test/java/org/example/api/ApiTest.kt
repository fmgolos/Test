package org.example.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.okhttp.OkHttpClient
import org.example.pojo.StringJson
import org.example.pojo.User
import org.example.service.User1
import org.junit.jupiter.api.Test

internal class ApiTest {

    private val client = createClient()

    private fun createClient(): FeignInterface {
        val objectMapper = ObjectMapper().registerKotlinModule()
        return Feign.builder().client(OkHttpClient())
            .encoder(JacksonEncoder(objectMapper))
            .decoder(JacksonDecoder(objectMapper))
            .target(FeignInterface::class.java, "http://localhost:8080/")
    }

    @Test
    fun `add new user`() {
        repeat(10) {
            client.addUser(User1("Danya", 15))
            client.addUser(User1("Fdr", 12))
            client.addUser(User1("Egor", 100))
        }
    }

    @Test
    fun `delete all users by name`() {
        val text = client.deleteUsersByName(StringJson("Danya")).text
        println(text)
    }

    @Test
    fun `edit user age`() {
        client.edit(User1("Fdr", 150))
    }

    @Test
    fun `edit user age111`() {
        client.search("Danya")
    }

    @Test
    fun `add new user to DB`() {
        repeat(10) {
            client.add(User(null, "Fdr", "123"))
        }
    }

}

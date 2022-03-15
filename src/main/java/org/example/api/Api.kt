package org.example.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.okhttp.OkHttpClient

class Api(private val host: String) {
    private val client = createClient()

    private fun createClient(): FeignInterface {
        val objectMapper = ObjectMapper().registerKotlinModule()
        return Feign.builder().client(OkHttpClient())
            .encoder(JacksonEncoder(objectMapper))
            .decoder(JacksonDecoder(objectMapper))
            .target(FeignInterface::class.java, "$host")
    }

    fun hello(): String {
        return client.hello()
    }

}

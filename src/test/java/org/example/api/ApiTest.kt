package org.example.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ApiTest {
    //    http://localhost:8080/
    @Test
    fun hello() {
        val api = Api("http://localhost:8080/")
        val a = api.hello()
        println(a)
    }
}
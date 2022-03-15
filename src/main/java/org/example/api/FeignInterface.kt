package org.example.api

import feign.Headers
import feign.RequestLine


@Headers(value = ["Accept: application/json", "Content-Type: application/json"])
interface FeignInterface {


    @RequestLine("GET /hello")
    fun hello(): String

}

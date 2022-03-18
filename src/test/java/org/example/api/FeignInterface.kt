package org.example.api

import feign.Headers
import feign.Param
import feign.RequestLine
import org.example.pojo.StringJson
import org.example.pojo.User
import org.example.service.User1


@Headers(value = ["Accept: application/json", "Content-Type: application/json"])
interface FeignInterface {

    @RequestLine("POST/addUser")
    fun addUser(user1: User1)

    @RequestLine("DELETE /user")
    fun deleteUsersByName(name: StringJson): StringJson

    @RequestLine("PUT /edit")
    fun edit(user1: User1)

    @RequestLine("GET /search?text={text}")
    fun search(@Param("text") text: String)

    @RequestLine("POST /add")
    fun add(user: User)
}

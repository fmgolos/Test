package org.example.controller

import org.example.pojo.User
import org.example.service.UserServiceJDBC
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DBController(private val userService: UserServiceJDBC) {

    @PostMapping("/add")
    fun addUser(@RequestBody user: User) {
        userService.add(user)
    }
}
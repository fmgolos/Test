package org.example.service

import org.example.pojo.User

import org.springframework.jdbc.core.JdbcTemplate

class UserServiceJDBC(private val jdbcTemplate: JdbcTemplate) {
    fun add(user: User) {
        jdbcTemplate.update("INSERT INTO phonebook  VALUES (default ,?,?)", user.name, user.phone)
    }
}
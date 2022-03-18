package org.example.service

import org.example.db.JdbcPersister
import org.example.pojo.User
import org.junit.jupiter.api.Test

internal class UserServiceDBTest {

    val url = "jdbc:postgresql://localhost:5432/postgres"
    val name = "postgres"
    val pass = "password"

    @Test
    fun add() {
        val jdbcPersister = JdbcPersister(url, name, pass)
        val us = UserServiceDB(jdbcPersister)
        val user = User(null, "Fdr", "123")
        us.add(user)
    }
}
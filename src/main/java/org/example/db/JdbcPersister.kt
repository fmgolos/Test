package org.example.db

import org.flywaydb.core.Flyway
import java.sql.Connection
import java.sql.DriverManager

class JdbcPersister(private val url: String, private val username: String, private val password: String) {
    fun connection(): Connection {
//        val flyway = Flyway.configure().dataSource(url, username, password).load();
//        flyway.migrate();
        return DriverManager.getConnection(url, username, password)
    }
}
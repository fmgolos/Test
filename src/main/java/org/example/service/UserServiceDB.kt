package org.example.service

import org.example.db.JdbcPersister
import org.example.pojo.User

class UserServiceDB(private val jdbcPersister: JdbcPersister) {
    fun add(user: User) {
        try {
            val preparedStatement =
                jdbcPersister.connection().prepareStatement("INSERT INTO phonebook VALUE (?,?)")
            preparedStatement.setString(1, user.name)
            preparedStatement.setString(2, user.phone)
            preparedStatement.executeUpdate()
            preparedStatement.close()
        } catch (e: Exception) {
            println(e)
        }
    }
}

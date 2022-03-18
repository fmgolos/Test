package org.example.service


import java.util.*

class UserService() {
    private val user1s = mutableListOf<User1>(User1("sdsds", 15))
    fun getUsers(): List<User1> {
        return user1s.toList()
    }

    fun addUser(user1: User1) {
        user1s.add(user1)
    }

    fun deleteUsersByName(name: String) {
        val usersList = findUsersByName(name)
        usersList.forEach { it -> user1s.remove(it) }
    }

    fun editUser(user1: User1) {
        user1s.forEach { it ->
            if (it.name == user1.name) {
                it.age = user1.age
            }
        }
    }

    fun filteredUsers(text: String): List<User1> {
        return user1s.filter { it -> it.name.lowercase(Locale.getDefault()).contains(text) }
    }

    private fun findUsersByName(name: String): List<User1> {
        val userList = user1s.filter { it -> it.name == name }
        return userList
    }

}

data class User1(val name: String, var age: Int)
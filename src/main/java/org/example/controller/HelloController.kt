package org.example.controller


import org.example.pojo.StringJson
import org.example.service.User1
import org.example.service.UserService
import org.springframework.web.bind.annotation.*


@RestController
class HelloController(private val userService: UserService) {
    @GetMapping("/hello")
    fun hello(): StringJson {
        return StringJson("Hello")
    }

    @GetMapping("/showAllUsers")
    fun showAllUsers(): List<User1> {
        return userService.getUsers()
    }

    @GetMapping("/search")
    fun search(@RequestParam("text") text: String): List<User1> {
        return userService.filteredUsers(text)
    }

    @PostMapping("/addUser")
    fun addUser(@RequestBody user1: User1) {
        userService.addUser(user1)
    }

    @DeleteMapping("/user")
    fun deleteUsersByName(@RequestBody name: StringJson): StringJson {
        userService.deleteUsersByName(name.text)
        return StringJson("Удалил всех юзеров с именем ${name.text}")
    }

    @PutMapping("/edit")
    fun editUserInfo(@RequestBody user1: User1) {
        userService.editUser(user1)
    }


}

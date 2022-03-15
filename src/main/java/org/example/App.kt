package org.example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication(App::class.java).run()
        }
    }
}
package org.example.config

import org.example.db.JdbcPersister
import org.example.service.UserService
import org.example.service.UserServiceJDBC
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource


@Configuration
class config {
    @Bean
    fun users(): UserService {
        return UserService()
    }

    @Bean
    fun persister(
        @Value("\${DB.URL}") url: String,
        @Value("\${DB.USERNAME}") userName: String,
        @Value("\${DB.PASSWORD}") password: String
    ): JdbcPersister {
        return JdbcPersister(url, userName, password)
    }

    @Bean
    fun dataSource(
        @Value("\${DB.URL}") url: String,
        @Value("\${DB.USERNAME}") userName: String,
        @Value("\${DB.PASSWORD}") password: String
    ): DriverManagerDataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.setDriverClassName("org.postgresql.Driver")
        dataSource.setUrl(url)
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource
    }

    @Bean
    fun jdbcTemplate(dataSource: DriverManagerDataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    fun userService(jdbcTemplate: JdbcTemplate): UserServiceJDBC {
        return UserServiceJDBC(jdbcTemplate)
    }

}
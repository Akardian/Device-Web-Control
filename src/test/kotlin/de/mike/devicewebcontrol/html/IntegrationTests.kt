package de.mike.devicewebcontrol.html

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

    @Test
    @DisplayName("Assert blog page title, content and status code")
    fun titleContentStatusTest(@Autowired restTemplate: TestRestTemplate){
        val entity = restTemplate.getForEntity<String>("/")

        println("\n Status Code: ${entity.statusCode} \n")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>Device Control</h1>")
    }
}
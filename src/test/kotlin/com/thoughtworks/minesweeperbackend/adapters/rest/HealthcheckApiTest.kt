package com.thoughtworks.minesweeperbackend.adapters.rest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
internal class HealthcheckApiTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `should return status up the helthcheck when app is running`(){
        // given
        val expectedStatus = "UP"

        // when/them
        mockMvc.get("/healthcheck")
            .andDo { print() }
            .andExpect {
                status { isOk()}
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.status") {value(expectedStatus)}
            }
    }
}
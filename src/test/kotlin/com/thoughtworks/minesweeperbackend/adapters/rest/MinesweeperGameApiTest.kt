package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.fasterxml.jackson.databind.ObjectMapper
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
internal class MinesweeperGameApiTest{

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    val baseUrl = "/api/games"
    val MIN_ROWS_AND_COLS = 3
    val MAX_ROWS_AND_COLS = 17
    val MIN_VALUE_ERROR_MSG = "The minimum amount of rows and cols to be configured is"
    val MAX_VALUE_ERROR_MSG = "The maximum amount of rows and cols to be configured is"

    @Test
    fun `should add a new game when arguments are valid` (){
        // given
        val expectedRows = 7
        val expectedCols = 5
        val expectedGameDifficulty = GameDifficulty.EASY
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty)

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(minesweeperGameType)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isCreated() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                }
                jsonPath("$.rows") { value(expectedRows)}
                jsonPath("$.cols") { value(expectedCols)}
                jsonPath("$.difficulty") { value(expectedGameDifficulty.toString())}
                jsonPath("$.id") { isNotEmpty() }
                jsonPath("$.id") { value(Matchers.hasLength(36)) }
            }
    }

    @Test
    fun `should return bad request when given a below the minimum value of rows` (){
        // given
        val expectedRows = 1
        val expectedCols = 5
        val expectedGameDifficulty = GameDifficulty.EASY
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty)

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(minesweeperGameType)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("$MIN_VALUE_ERROR_MSG $MIN_ROWS_AND_COLS") }
            }
    }

    @Test
    fun `should return bad request when given a below the minimum value of cols` (){
        // given
        val expectedRows = 6
        val expectedCols = 1
        val expectedGameDifficulty = GameDifficulty.EASY
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty)

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(minesweeperGameType)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("$MIN_VALUE_ERROR_MSG $MIN_ROWS_AND_COLS") }
            }
    }

    @Test
    fun `should return bad request when given a above the maximum value of rows` (){
        // given
        val expectedRows = 25
        val expectedCols = 6
        val expectedGameDifficulty = GameDifficulty.EASY
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty)

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(minesweeperGameType)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("$MAX_VALUE_ERROR_MSG $MAX_ROWS_AND_COLS") }
            }
    }

    @Test
    fun `should return bad request when given a above the maximum value of cols` (){
        // given
        val expectedRows = 6
        val expectedCols = 25
        val expectedGameDifficulty = GameDifficulty.EASY
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty)

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(minesweeperGameType)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("$MAX_VALUE_ERROR_MSG $MAX_ROWS_AND_COLS") }
            }
    }

    @Test
    fun `should return bad request when one of the parameters is missing` (){
        // given
        val expectedRows = 6
        val expectedCols = 25
        val expectedGameDifficulty = GameDifficulty.EASY
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty)

        val contents = objectMapper.writeValueAsString(minesweeperGameType)

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(minesweeperGameType)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("$MAX_VALUE_ERROR_MSG $MAX_ROWS_AND_COLS") }
            }
    }

    @Test
    fun `should not create a minesweeper game when the rows value is missing` (){
        // given
        val expectedCols = 10
        val expectedGameDifficulty = GameDifficulty.EASY
        val contentObject = object {
            val cols = expectedCols
            val difficulty = expectedGameDifficulty
        }

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(contentObject)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("The rows value is missing") }
            }
    }

    @Test
    fun `should not create a minesweeper game when the cols value is missing` (){
        // given
        val expectedRows = 10
        val expectedGameDifficulty = GameDifficulty.EASY
        val contentObject = object {
            val rows = expectedRows
            val difficulty = expectedGameDifficulty
        }

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(contentObject)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("The cols value is missing") }
            }
    }

    @Test
    fun `should not create a minesweeper game when the difficulty value is missing` (){
        // given
        val expectedRows = 10
        val expectedCols = 10
        val contentObject = object {
            val rows = expectedRows
            val cols = expectedCols
        }

        // when
        val performPost = mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(contentObject)
        }

        // then
        performPost
            .andDo{ print() }
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.detail") { value("The difficulty value is missing") }
            }
    }
}

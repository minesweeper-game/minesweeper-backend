package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RestMinesweeperGameHandlerTest{

    @Test
    fun `should create minesweeper game using minesweeper game handler`(){
        // given
        val expectedRows = 5
        val expectedCols = 7
        val expectedDifficulty = GameDifficulty.EASY

        // when
        val restMinesweeperGameHandler = RestMinesweeperGameHandler()
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedDifficulty)
        val minesweeperGameResponse = restMinesweeperGameHandler.add(minesweeperGameType)

        // then
        assertNotNull(minesweeperGameResponse)
        assertThat(minesweeperGameResponse.id).isNotBlank
        assertThat(minesweeperGameResponse.rows).isEqualTo(expectedRows)
        assertThat(minesweeperGameResponse.cols).isEqualTo(expectedCols)
        assertThat(minesweeperGameResponse.difficulty).isEqualTo(expectedDifficulty)
    }
}
package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class MinesweeperGameResponseTest {

    @Test
    fun `should create a minesweeper game response from a minesweeper game type`(){
        // given
        val expectedId = UUID.randomUUID().toString()
        val expectedRows = 5
        val expectedCols = 7
        val expectedGameDifficulty = GameDifficulty.EASY

        // when
        val minesweeperGameType = MinesweeperGameType(expectedRows, expectedCols, expectedGameDifficulty, expectedId)
        val minesweeperGameResponse = MinesweeperGameResponse.fromMinesweeperGameType(minesweeperGameType)

        // then
        assertThat(minesweeperGameResponse.id).isEqualTo(expectedId)
        assertThat(minesweeperGameResponse.rows).isEqualTo(expectedRows)
        assertThat(minesweeperGameResponse.cols).isEqualTo(expectedCols)
        assertThat(minesweeperGameResponse.difficulty).isEqualTo(expectedGameDifficulty)
    }
}
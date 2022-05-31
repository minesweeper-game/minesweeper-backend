package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinesweeperBoardBoxTest{

    @Test
    fun `should create a minesweeper game board when correct values are given`(){
        // given
        val expectedRows = 5
        val expectedCols = 7
        val expectedGameDifficulty = GameDifficulty.EASY

        // when
        val minesweeperGameBoard = MinesweeperGameBoard(expectedRows, expectedCols, expectedGameDifficulty)

        // then
        assertThat(minesweeperGameBoard.rows).isEqualTo(expectedRows)
        assertThat(minesweeperGameBoard.cols).isEqualTo(expectedCols)
        assertThat(minesweeperGameBoard.difficulty).isEqualTo(expectedGameDifficulty)
    }
}
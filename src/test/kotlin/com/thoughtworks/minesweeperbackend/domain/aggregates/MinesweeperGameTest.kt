package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.thoughtworks.minesweeperbackend.domain.entities.MinesweeperGameBoard
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameStatus
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinesweeperGameTest{

    @Test
    fun `should create a minesweeper game when correct values are given`(){
        // given
        val expectedRows = 5
        val expectedCols = 7
        val expectedGameDifficulty = GameDifficulty.EASY
        val expectedBoard = MinesweeperGameBoard(expectedRows, expectedCols, expectedGameDifficulty)

        // when
        val minesweeperGame= MinesweeperGame(expectedBoard, expectedGameDifficulty)

        // then
        assertThat(minesweeperGame.id).isNotBlank
        assertThat(minesweeperGame.id.length).isEqualTo(36)
        assertThat(minesweeperGame.status).isEqualTo(GameStatus.INITIALIZED)
        assertThat(minesweeperGame.board).isNotNull
        assertThat(minesweeperGame.difficulty).isEqualTo(expectedGameDifficulty)
    }
}
package com.thoughtworks.minesweeperbackend.domain.services

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinesweeperGameServiceTest{

    @Test
    fun `should create a minesweeper game service with correct values`(){
        // given
        val rows = 5
        val cols = 7
        val difficulty = GameDifficulty.EASY

        // when
        val minesweeperGameService = MinesweeperGameService()
        val minesweeperGame= minesweeperGameService.create(rows, cols, difficulty)

        // then
        assertThat(minesweeperGame.status).isEqualTo(GameStatus.INITIALIZED)
        assertThat(minesweeperGame.id.length).isEqualTo(36)
        assertThat(minesweeperGame.status).isEqualTo(GameStatus.INITIALIZED)
        assertThat(minesweeperGame.board).isNotNull
        assertThat(minesweeperGame.difficulty).isEqualTo(difficulty)
    }
}
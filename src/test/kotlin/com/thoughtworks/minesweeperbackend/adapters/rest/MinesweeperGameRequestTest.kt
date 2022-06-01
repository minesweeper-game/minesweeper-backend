package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MinesweeperGameRequestTest{

    @Test
    fun `should create a minesweeperGameType from a MinesweeperGameRequest successfully` (){
        // given
        val rows = 8
        val cols = 8
        val difficulty = GameDifficulty.EASY

        // when
        val minesweeperGameRequest = MinesweeperGameRequest(rows, cols, difficulty)
        val minesweeperGameType = minesweeperGameRequest.toMinesweeperGameType()

        // then
        assertThat ( minesweeperGameType.rows ).isEqualTo(rows)
        assertThat ( minesweeperGameType.cols ).isEqualTo(cols)
        assertThat ( minesweeperGameType.difficulty ).isEqualTo(difficulty)
    }
}
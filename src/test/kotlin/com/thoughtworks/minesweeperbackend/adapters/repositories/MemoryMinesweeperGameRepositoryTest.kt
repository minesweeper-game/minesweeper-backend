package com.thoughtworks.minesweeperbackend.adapters.repositories

import com.thoughtworks.minesweeperbackend.adapters.rest.MinesweeperGameRequest
import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MemoryMinesweeperGameRepositoryTest{

    @Test
    fun `should create a minesweeperGameType from a MinesweeperGameRequest successfully` (){
        // given
        val rows = 8
        val cols = 8
        val difficulty = GameDifficulty.EASY

        // when
        val memoryMinesweeperGameRepository = MemoryMinesweeperGameRepository()
        val minesweeperGameType = MinesweeperGameType(rows, cols, difficulty)
        val minesweeperGameTypeReturned = memoryMinesweeperGameRepository.add(minesweeperGameType)

        // then
        assertThat(minesweeperGameTypeReturned.id.length).isEqualTo(36)
        assertThat(minesweeperGameTypeReturned.rows).isEqualTo(rows)
        assertThat(minesweeperGameTypeReturned.cols).isEqualTo(cols)
        assertThat(minesweeperGameTypeReturned.difficulty).isEqualTo(difficulty)
    }
}
package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.BoardBoxStatus
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MinesweeperBoardBoxTest{

    @Test
    fun `should should create minesweeper board box`(){
        // when
        val minesweeperBoardBox = MinesweeperBoardBox()

        // then
        assertThat(minesweeperBoardBox.status).isEqualTo(BoardBoxStatus.CLOSED)
        assertThat(minesweeperBoardBox.is_mined).isEqualTo(false)
    }
}
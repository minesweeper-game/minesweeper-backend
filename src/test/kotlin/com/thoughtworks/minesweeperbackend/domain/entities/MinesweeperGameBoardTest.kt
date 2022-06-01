package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


internal class MinesweeperGameBoardTest{

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
        assertThat(minesweeperGameBoard.boardBoxes).isNotEmpty
        assertThat(minesweeperGameBoard.boardBoxes.size).isEqualTo(expectedRows)
        assertThat(minesweeperGameBoard.boardBoxes.first().size).isEqualTo(expectedCols)
    }

    @Test
    fun `should not create a minesweeper game board when min rows is invalid` (){
        // given
        val expectedRows = 2
        val expectedCols = 7
        val expectedGameDifficulty = GameDifficulty.EASY

        // when
        val thrown = assertThrows(IllegalArgumentException::class.java) {
            MinesweeperGameBoard(expectedRows, expectedCols, expectedGameDifficulty)
        }

        // then
        assertEquals("The minimum amount of rows and cols to be configured is 3", thrown.message)
    }
    
    @Test
    fun `should not create a minesweeper game board when min cols is invalid` (){
        // given
        val expectedRows = 7
        val expectedCols = 2
        val expectedGameDifficulty = GameDifficulty.EASY

        // when
        val thrown = assertThrows(IllegalArgumentException::class.java) {
            MinesweeperGameBoard(expectedRows, expectedCols, expectedGameDifficulty)
        }

        // then
        assertEquals("The minimum amount of rows and cols to be configured is 3", thrown.message)
    }

    @Test
    fun `should not create a minesweeper game board when max rows is invalid` (){
        // given
        val expectedRows = 19
        val expectedCols = 7
        val expectedGameDifficulty = GameDifficulty.EASY

        // when
        val thrown = assertThrows(IllegalArgumentException::class.java) {
            MinesweeperGameBoard(expectedRows, expectedCols, expectedGameDifficulty)
        }

        // then
        assertEquals("The maximum amount of rows and cols to be configured is 17", thrown.message)
    }

    @Test
    fun `should not create a minesweeper game board when max cols is invalid` (){
        // given
        val expectedRows = 7
        val expectedCols = 19
        val expectedGameDifficulty = GameDifficulty.EASY

        // when
        val thrown = assertThrows(IllegalArgumentException::class.java) {
            MinesweeperGameBoard(expectedRows, expectedCols, expectedGameDifficulty)
        }

        // then
        assertEquals("The maximum amount of rows and cols to be configured is 17", thrown.message);
    }

    @Test
    fun `should calculate correctly the amount of mine when the game is easy` (){
        // given
        val rows = 7
        val cols = 3
        val difficulty = GameDifficulty.EASY
        val expectedAmountOfMines = 2

        // when
        val minesweeperGameBoard = MinesweeperGameBoard(rows, cols, difficulty)

        // then
        assertThat(minesweeperGameBoard.amountOfMines).isEqualTo(expectedAmountOfMines)
    }

    @Test
    fun `should calculate correctly the amount of mine when the game is medium` (){
        // given
        val rows = 3
        val cols = 5
        val difficulty = GameDifficulty.MEDIUM
        val expectedAmountOfMines = 8

        // when
        val minesweeperGameBoard = MinesweeperGameBoard(rows, cols, difficulty)

        // then
        assertThat(minesweeperGameBoard.amountOfMines).isEqualTo(expectedAmountOfMines)
    }

    @Test
    fun `should calculate correctly the amount of mine when the game is hard` (){
        // given
        val rows = 5
        val cols = 4
        val difficulty = GameDifficulty.HARD
        val expectedAmountOfMines = 15

        // when
        val minesweeperGameBoard = MinesweeperGameBoard(rows, cols, difficulty)

        // then
        assertThat(minesweeperGameBoard.amountOfMines).isEqualTo(expectedAmountOfMines)
    }
}
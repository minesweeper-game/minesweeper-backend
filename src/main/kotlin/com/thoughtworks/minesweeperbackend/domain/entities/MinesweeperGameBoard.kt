package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

class MinesweeperGameBoard {


    val MIN_ROWS_AND_COLS = 3
    val MAX_ROWS_AND_COLS = 17

    val rows: Int
    val cols: Int
    val difficulty: GameDifficulty
    val boardBoxes: Array<Array<MinesweeperBoardBox>>

    constructor(rows: Int, cols: Int, difficulty: GameDifficulty ){

        if (rows < MIN_ROWS_AND_COLS || cols < MIN_ROWS_AND_COLS) throw IllegalArgumentException("The minimum amount of rows and cols to be configured is $MIN_ROWS_AND_COLS")
        if (rows > MAX_ROWS_AND_COLS || cols > MAX_ROWS_AND_COLS) throw IllegalArgumentException("The maximum amount of rows and cols to be configured is $MAX_ROWS_AND_COLS")

        this.rows = rows
        this.cols = cols
        this.difficulty = difficulty
        this.boardBoxes = Array(rows) { Array (cols) { MinesweeperBoardBox() } }

    }
}
package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

class MinesweeperGameRequest {

    val rows: Int?
    val cols: Int?
    val difficulty: GameDifficulty?

    val MIN_ROWS_AND_COLS = 3
    val MAX_ROWS_AND_COLS = 17

    constructor(rows: Int? = null, cols: Int? = null, difficulty: GameDifficulty? = null){

        if (rows == null) throw IllegalArgumentException("The rows value is missing")
        if (cols == null) throw IllegalArgumentException("The cols value is missing")
        if (difficulty == null) throw IllegalArgumentException("The difficulty value is missing")

        if (rows < MIN_ROWS_AND_COLS || cols < MIN_ROWS_AND_COLS) throw IllegalArgumentException("The minimum amount of rows and cols to be configured is $MIN_ROWS_AND_COLS")
        if (rows > MAX_ROWS_AND_COLS || cols > MAX_ROWS_AND_COLS) throw IllegalArgumentException("The maximum amount of rows and cols to be configured is $MAX_ROWS_AND_COLS")

        this.rows = rows
        this.cols = cols
        this.difficulty = difficulty
    }

    fun toMinesweeperGameType () : MinesweeperGameType {
        return MinesweeperGameType(this.rows!!, this.cols!!, this.difficulty!!)
    }
}
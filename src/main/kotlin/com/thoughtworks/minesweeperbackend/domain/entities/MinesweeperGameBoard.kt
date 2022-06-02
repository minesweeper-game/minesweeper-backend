package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import kotlin.math.roundToInt
import kotlin.random.Random

class MinesweeperGameBoard {

    val MIN_ROWS_AND_COLS = 3
    val MAX_ROWS_AND_COLS = 17
    val MINES_PERCENTAGE_EASY = 10
    val MINES_PERCENTAGE_MEDIUM = 50
    val MINES_PERCENTAGE_HARD = 75

    val rows: Int
    val cols: Int
    val difficulty: GameDifficulty
    val boardBoxes: Array<Array<MinesweeperBoardBox>>
    val amountOfMines: Int

    constructor(rows: Int?, cols: Int?, difficulty: GameDifficulty? ){
        if (rows == null) throw IllegalArgumentException("The rows value is missing")
        if (cols == null) throw IllegalArgumentException("The cols value is missing")
        if (difficulty == null) throw IllegalArgumentException("The difficulty value is missing")

        if (rows < MIN_ROWS_AND_COLS || cols < MIN_ROWS_AND_COLS) throw IllegalArgumentException("The minimum amount of rows and cols to be configured is $MIN_ROWS_AND_COLS")
        if (rows > MAX_ROWS_AND_COLS || cols > MAX_ROWS_AND_COLS) throw IllegalArgumentException("The maximum amount of rows and cols to be configured is $MAX_ROWS_AND_COLS")

        this.rows = rows
        this.cols = cols
        this.difficulty = difficulty
        this.boardBoxes = Array(rows) { Array (cols) { MinesweeperBoardBox() } }
        this.amountOfMines = this.calculateAmountOfMines()
        this.assignMines()
    }

    private fun calculateAmountOfMines(): Int{
        val minesPercent =  when(this.difficulty){
            GameDifficulty.EASY -> MINES_PERCENTAGE_EASY
            GameDifficulty.MEDIUM -> MINES_PERCENTAGE_MEDIUM
            GameDifficulty.HARD -> MINES_PERCENTAGE_HARD
        } / 100.0
        val amount = this.rows * this.cols * minesPercent
        return amount.roundToInt()
    }

    private fun assignMines(){
        var assignedMines = 0

        while (assignedMines < this.amountOfMines){
            val row = Random.nextInt(0, this.rows)
            val col = Random.nextInt(0, this.cols)

            if (!this.boardBoxes[row][col].is_mined){
                this.boardBoxes[row][col].is_mined = true
                assignedMines++
            }
        }
    }
}
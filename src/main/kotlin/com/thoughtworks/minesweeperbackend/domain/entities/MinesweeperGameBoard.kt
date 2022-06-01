package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

class MinesweeperGameBoard {

    val rows: Int
    val cols: Int
    val difficulty: GameDifficulty
    val boardBoxes: Array<Array<MinesweeperBoardBox>>


    constructor(rows: Int, cols: Int, difficulty: GameDifficulty ){
        this.rows = rows
        this.cols = cols
        this.difficulty = difficulty
        this.boardBoxes = Array(rows) { Array (cols) { MinesweeperBoardBox() } }
    }
}
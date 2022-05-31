package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

class MinesweeperGameBoard {
    val rows: Int
    val cols: Int
    val difficulty: GameDifficulty

    constructor(rows: Int, cols: Int, difficulty: GameDifficulty ){
        this.rows = rows
        this.cols = cols
        this.difficulty = difficulty
    }
}
package com.thoughtworks.minesweeperbackend.domain.services

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGame
import com.thoughtworks.minesweeperbackend.domain.entities.MinesweeperGameBoard
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

class MinesweeperGameService {

    fun create(rows: Int, cols: Int, difficulty: GameDifficulty): MinesweeperGame {
        val minesweeperGameBoard = MinesweeperGameBoard(rows, cols, difficulty)
        return MinesweeperGame(minesweeperGameBoard, difficulty)
    }
}
package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.thoughtworks.minesweeperbackend.domain.entities.MinesweeperGameBoard
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameStatus
import java.util.*


class MinesweeperGame(val board: MinesweeperGameBoard, val difficulty: GameDifficulty) {
    val id: String = UUID.randomUUID().toString()
    val status: GameStatus = GameStatus.INITIALIZED
}
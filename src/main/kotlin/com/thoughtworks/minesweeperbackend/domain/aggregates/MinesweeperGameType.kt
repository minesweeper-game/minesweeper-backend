package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

data class MinesweeperGameType(val id: String, val rows: Int, val cols: Int, val difficulty: GameDifficulty)

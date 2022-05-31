package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

data class MinesweeperGameType(val rows: Int, val cols: Int, val difficulty: GameDifficulty, val id: String = "")

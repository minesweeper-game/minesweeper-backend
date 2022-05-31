package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.value_objects.GameDifficulty

class MinesweeperGameResponse(var id: String, val rows: Int, val cols: Int, val difficulty: GameDifficulty) {

    companion object {
        fun fromMinesweeperGameType(minesweeperGameType: MinesweeperGameType): MinesweeperGameResponse{
            return MinesweeperGameResponse(
                minesweeperGameType.id,
                minesweeperGameType.rows,
                minesweeperGameType.cols,
                minesweeperGameType.difficulty
            )
        }
    }
}

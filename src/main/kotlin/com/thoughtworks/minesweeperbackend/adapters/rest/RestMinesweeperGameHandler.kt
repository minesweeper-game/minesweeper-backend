package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGame
import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.entities.MinesweeperGameBoard
import com.thoughtworks.minesweeperbackend.domain_ports.MinesweeperGameHandler

class RestMinesweeperGameHandler: MinesweeperGameHandler {

    override fun add(minesweeperGameType: MinesweeperGameType): MinesweeperGameResponse{
        val minesweeperGameBoard = MinesweeperGameBoard(minesweeperGameType.rows, minesweeperGameType.cols, minesweeperGameType.difficulty)
        val minesweeperGame = MinesweeperGame(minesweeperGameBoard, minesweeperGameType.difficulty)

        val minesweeperGameResponse = MinesweeperGameResponse.fromMinesweeperGameType(minesweeperGameType)
        minesweeperGameResponse.id = minesweeperGame.id
        return minesweeperGameResponse
    }
}
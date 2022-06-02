package com.thoughtworks.minesweeperbackend.adapters.repositories

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGame
import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.services.MinesweeperGameService
import com.thoughtworks.minesweeperbackend.domain_ports.MinesweeperGameRepository

class MemoryMinesweeperGameRepository: MinesweeperGameRepository {

    private val minesweeperGameService = MinesweeperGameService()
    private val minesweeperGameData : HashMap<String, MinesweeperGame> = HashMap()

    override fun add(minesweeperGameType: MinesweeperGameType): MinesweeperGameType {
        try {
            val minesweeperGame = this.minesweeperGameService.create(minesweeperGameType.rows, minesweeperGameType.cols, minesweeperGameType.difficulty)
            minesweeperGameData[minesweeperGame.id] = minesweeperGame
            return MinesweeperGameType(minesweeperGameType.rows, minesweeperGameType.cols, minesweeperGameType.difficulty, minesweeperGame.id)
        }catch (e: Exception){
            throw e
        }
    }
}
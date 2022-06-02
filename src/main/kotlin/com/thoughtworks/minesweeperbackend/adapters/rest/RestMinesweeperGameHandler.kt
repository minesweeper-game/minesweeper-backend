package com.thoughtworks.minesweeperbackend.adapters.rest

import com.thoughtworks.minesweeperbackend.adapters.repositories.MemoryMinesweeperGameRepository
import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain_ports.MinesweeperGameHandler

class RestMinesweeperGameHandler: MinesweeperGameHandler {

    private val minesweeperGameRepository = MemoryMinesweeperGameRepository()

    override fun add(minesweeperGameType: MinesweeperGameType): MinesweeperGameResponse {
        val minesweeperGameType = minesweeperGameRepository.add(minesweeperGameType)
        return MinesweeperGameResponse.fromMinesweeperGameType(minesweeperGameType)
    }
}
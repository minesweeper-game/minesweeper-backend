package com.thoughtworks.minesweeperbackend.adapters.repositories

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType
import com.thoughtworks.minesweeperbackend.domain.services.MinesweeperGameService
import com.thoughtworks.minesweeperbackend.domain_ports.MinesweeperGameRepository

class MemoryMinesweeperGameRepository: MinesweeperGameRepository {

    val minesweeperGameService = MinesweeperGameService()

    override fun add(minesweeperGameType: MinesweeperGameType): MinesweeperGameType {
        TODO("Not yet implemented")
    }
}
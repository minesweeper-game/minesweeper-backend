package com.thoughtworks.minesweeperbackend.domain_ports

import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType

interface MinesweeperGameRepository {

    fun add(minesweeperGameType: MinesweeperGameType): MinesweeperGameType
}
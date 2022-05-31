package com.thoughtworks.minesweeperbackend.domain_ports

import com.thoughtworks.minesweeperbackend.adapters.rest.MinesweeperGameResponse
import com.thoughtworks.minesweeperbackend.domain.aggregates.MinesweeperGameType

interface MinesweeperGameHandler {
    fun add(minesweeperGameType: MinesweeperGameType): MinesweeperGameResponse
}
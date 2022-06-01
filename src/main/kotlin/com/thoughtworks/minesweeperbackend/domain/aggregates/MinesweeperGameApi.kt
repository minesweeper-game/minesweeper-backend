package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.thoughtworks.minesweeperbackend.adapters.rest.MinesweeperGameResponse
import com.thoughtworks.minesweeperbackend.adapters.rest.RestMinesweeperGameHandler
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/games")
class MinesweeperGameApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody minesweeperGameType: MinesweeperGameType): MinesweeperGameResponse {
        return RestMinesweeperGameHandler().add(minesweeperGameType)
    }
}
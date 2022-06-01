package com.thoughtworks.minesweeperbackend.domain.aggregates

import com.thoughtworks.minesweeperbackend.adapters.rest.BadRequestResponse
import com.thoughtworks.minesweeperbackend.adapters.rest.MinesweeperGameRequest
import com.thoughtworks.minesweeperbackend.adapters.rest.MinesweeperGameResponse
import com.thoughtworks.minesweeperbackend.adapters.rest.RestMinesweeperGameHandler
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/games")
class MinesweeperGameApi {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<BadRequestResponse> = ResponseEntity(BadRequestResponse(e.message), HttpStatus.BAD_REQUEST)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody minesweeperGameRequest: MinesweeperGameRequest): MinesweeperGameResponse {
        return RestMinesweeperGameHandler().add(minesweeperGameRequest.toMinesweeperGameType())
    }
}
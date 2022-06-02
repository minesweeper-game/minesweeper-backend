package com.thoughtworks.minesweeperbackend.adapters.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/api/games")
class MinesweeperGameApi {

    val minesweeperGameHandler = RestMinesweeperGameHandler()

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<BadRequestResponse> = ResponseEntity(
        BadRequestResponse(e.message), HttpStatus.BAD_REQUEST)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody minesweeperGameRequest: MinesweeperGameRequest): MinesweeperGameResponse {
        return minesweeperGameHandler.add(minesweeperGameRequest.toMinesweeperGameType())
    }
}
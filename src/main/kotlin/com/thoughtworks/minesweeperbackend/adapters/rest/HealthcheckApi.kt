package com.thoughtworks.minesweeperbackend.adapters.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HealthcheckApi {

    @GetMapping
    fun home() : String = "Welcome to Minesweeper Game API!!!"

    @GetMapping("/healthcheck")
    fun healthcheck(): Any {
        return object {
            val status = "UP"
        }
    }
}
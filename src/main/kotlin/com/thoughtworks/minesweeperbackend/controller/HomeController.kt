package com.thoughtworks.minesweeperbackend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/")
class HomeController {

    @GetMapping
    fun home() : String = UUID.randomUUID().toString()
}
package com.thoughtworks.minesweeperbackend.domain.entities

import com.thoughtworks.minesweeperbackend.domain.value_objects.BoardBoxStatus

data class MinesweeperBoardBox(
    val status : BoardBoxStatus = BoardBoxStatus.CLOSED,
    var is_mined: Boolean = false
)

package com.example.hw6exercise21
import java.util.*

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    val requiresPolice : Boolean
)


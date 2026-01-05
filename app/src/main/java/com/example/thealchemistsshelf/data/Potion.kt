package com.example.thealchemistsshelf.data

import androidx.annotation.StringRes
import com.example.thealchemistsshelf.R

data class Potion(
    val id: Int,
    @get:StringRes val nameRes: Int,
    @get:StringRes val descRes: Int,
    val price: Double
)

val shopInventory = listOf(
    Potion(1, R.string.potion_healing, R.string.desc_healing, 5.50),
    Potion(2, R.string.potion_mana, R.string.desc_mana, 12.00),
    Potion(3, R.string.potion_stamina, R.string.desc_stamina, 8.75)
)
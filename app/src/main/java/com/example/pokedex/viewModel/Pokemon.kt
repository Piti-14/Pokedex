package com.example.pokedex.viewModel

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val name: String,
    val lvl: Int,
    val firstType: String,
    val secondType: String,
    val weight: Double,
    val height: Double,
    @DrawableRes val image: Int,

)//AMPLIAR
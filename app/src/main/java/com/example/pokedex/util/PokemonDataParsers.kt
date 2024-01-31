package com.example.pokedex.util

import androidx.compose.ui.graphics.Color
import com.example.pokedex.data.sources.remote.DTOs.Stat
import com.example.pokedex.ui.theme.AtkColor
import com.example.pokedex.ui.theme.DefColor
import com.example.pokedex.ui.theme.HPColor
import com.example.pokedex.ui.theme.SpAtkColor
import com.example.pokedex.ui.theme.SpDefColor
import com.example.pokedex.ui.theme.SpdColor

fun parseStatToColor(stat: Stat): Color{
    return when(stat.stat.name.lowercase()){
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbreviation(stat: Stat): String {
    return when(stat.stat.name.lowercase()){
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SP_ATK"
        "special-defense" -> "SP_DEF"
        "speed" -> "SPD"
        else -> ""
    }
}
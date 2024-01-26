package com.example.pokedex.domain.models

import com.example.pokedex.data.sources.remote.DTOs.Sprites
import com.example.pokedex.data.sources.remote.DTOs.Stat
import com.example.pokedex.data.sources.remote.DTOs.Type

data class Pokemon(
    val name: String,
    val height: Float,
    val weight: Float,
    val baseExp: Int,
    val id: Int,
    val sprite: Sprites,
    val stats: List<Stat>,
    val types: List<Type>
)
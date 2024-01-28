package com.example.pokedex.data.sources.remote.DTOs

data class PokemonListDTO(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<Result>
)
package com.example.pokedex.domain.repositories

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO

interface PokemonDetailRepository {
    suspend fun getPokemon(filename: String): PokemonDTO
}
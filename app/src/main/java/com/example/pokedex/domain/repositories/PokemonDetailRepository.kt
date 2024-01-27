package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.Pokemon

interface PokemonDetailRepository {

    suspend fun getPokemon(filename: String): Pokemon
}
package com.example.pokedex.domain.repositories

import com.example.pokedex.domain.models.PokemonList

interface PokemonListRepository {

    suspend fun getPokemonList(limit: Int): PokemonList
}
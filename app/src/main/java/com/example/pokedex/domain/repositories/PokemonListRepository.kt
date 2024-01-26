package com.example.pokedex.domain.repositories

import com.example.pokedex.data.sources.remote.DTOs.PokemonList

interface PokemonListRepository {

    suspend fun getPokemonList(): PokemonList
}
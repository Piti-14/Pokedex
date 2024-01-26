package com.example.pokedex.domain.repositories

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTOList

interface PokemonListRepository {

    suspend fun getPokemonList(): PokemonDTOList
}
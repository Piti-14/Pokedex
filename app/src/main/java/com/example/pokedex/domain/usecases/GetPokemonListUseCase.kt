package com.example.pokedex.domain.usecases

import com.example.pokedex.data.repositories.FallbackPokemonRepositoryImpl
import com.example.pokedex.domain.models.PokemonList
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val fallbackPokemonRepositoryImpl: FallbackPokemonRepositoryImpl){

    suspend fun getPokemonList(limit: Int): PokemonList {
        return fallbackPokemonRepositoryImpl.getPokemonList(limit)
    }
}
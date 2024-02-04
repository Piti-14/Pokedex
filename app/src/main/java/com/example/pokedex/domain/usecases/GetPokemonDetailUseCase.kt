package com.example.pokedex.domain.usecases

import com.example.pokedex.data.repositories.FallbackPokemonRepositoryImpl
import com.example.pokedex.domain.models.Pokemon
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val fallbackPokemonRepositoryImpl: FallbackPokemonRepositoryImpl){

    suspend fun getPokemonDetail(pokemonName: String): Pokemon {
        return fallbackPokemonRepositoryImpl.getPokemon(pokemonName)
    }
}
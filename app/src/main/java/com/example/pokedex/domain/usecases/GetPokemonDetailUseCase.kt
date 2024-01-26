package com.example.pokedex.domain.usecases

import com.example.pokedex.data.repositories.PokemonDetailRepositoryImpl
import com.example.pokedex.domain.models.Pokemon
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val pokemonRepository: PokemonDetailRepositoryImpl){

    suspend fun getPokemonDetail(pokemonName: String): Pokemon {
        return pokemonRepository.getPokemon(pokemonName)
    }
}
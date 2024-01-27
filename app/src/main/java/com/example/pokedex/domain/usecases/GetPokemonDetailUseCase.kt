package com.example.pokedex.domain.usecases

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonDetailRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(private val pokemonRepository: PokemonDetailRepository){

    suspend fun getPokemonDetail(pokemonName: String): Pokemon {
        return pokemonRepository.getPokemon(pokemonName)
    }
}
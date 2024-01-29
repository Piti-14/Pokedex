package com.example.pokedex.domain.usecases

import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val pokemonListRepository: PokemonListRepository){

    suspend fun getPokemonList(limit: Int): PokemonList {
        return pokemonListRepository.getPokemonList(limit)
    }
}
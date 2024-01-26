package com.example.pokedex.domain.usecases

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.domain.repositories.PokemonDetailRepository
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor( private val pokemonRepository: PokemonDetailRepository){
    //Aqu
    suspend fun getPokemonDetail(pokemonName: String): PokemonDTO {
        return pokemonRepository.getPokemon(pokemonName)
    }
}
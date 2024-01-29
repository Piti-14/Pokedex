package com.example.pokedex.data.sources.remote

import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(private val pokemonApi: PokemonApiService){

    suspend fun getPokemonDTOList(limit: Int): PokemonListDTO{

        return pokemonApi.getPokemonList(limit)
    }

    suspend fun getPokemonDTO(pokemonName: String): PokemonDTO{

        return pokemonApi.getPokemonDetail(pokemonName)
    }
}
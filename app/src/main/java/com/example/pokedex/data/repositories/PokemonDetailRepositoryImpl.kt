package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repositories.PokemonDetailRepository
import com.example.pokedex.mappers.PokemonDataMapper
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val pokemonLocalDataSource: PokemonLocalDataSource,
    private val pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonDetailRepository{
    //El return se iria a un mapper para crear NUESTRO modelo Pokemon del domain
    override suspend fun getPokemon(filename: String): Pokemon {
        val pokemonDTO: PokemonDTO = pokemonRemoteDataSource.getPokemonDTO(filename)
        return PokemonDataMapper.PokemonFromDTO(pokemonDTO)
    }
}
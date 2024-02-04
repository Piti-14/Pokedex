package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.data.sources.remote.DTOs.PokemonListDTO
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.IPokemonRepository
import com.example.pokedex.mappers.PokemonDataMapper
import javax.inject.Inject

class LocalDataPokemonRepositoryImpl @Inject constructor(
    private val pokemonLocalDataSource: PokemonLocalDataSource): IPokemonRepository {
    //El return se iria a un mapper para crear NUESTRO modelo Pokemon del domain
    override suspend fun getPokemon(pokemonName: String): Pokemon {
        val pokemonDTO: PokemonDTO = pokemonLocalDataSource.getPokemonFromJSON(pokemonName)
        return PokemonDataMapper.PokemonFromDTO(pokemonDTO)
    }

    override suspend fun getPokemonList(limit: Int): PokemonList {
        val pokemonDTOList: PokemonListDTO = pokemonLocalDataSource.getPokemonList()
        return PokemonDataMapper.PokemonsFromDTOList(pokemonDTOList)
    }
}
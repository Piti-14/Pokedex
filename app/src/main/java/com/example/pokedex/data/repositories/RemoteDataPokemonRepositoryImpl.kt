package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.IPokemonRepository
import com.example.pokedex.mappers.PokemonDataMapper
import javax.inject.Inject


class RemoteDataPokemonRepositoryImpl @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteDataSource): IPokemonRepository {
    override suspend fun getPokemon(pokemonName: String): Pokemon {
        val pokemon = pokemonRemoteDataSource.getPokemonDTO(pokemonName)
        return PokemonDataMapper.PokemonFromDTO(pokemon)
    }

    override suspend fun getPokemonList(limit: Int): PokemonList {
        val pokemonList = pokemonRemoteDataSource.getPokemonDTOList(limit) //esto es una PokemonListDTO

        return PokemonDataMapper.PokemonsFromDTOList(pokemonList)
    }
}
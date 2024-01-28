package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.PokemonListRepository
import com.example.pokedex.mappers.PokemonDataMapper
import javax.inject.Inject


class PokemonListRepositoryImpl @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonListRepository {
    override suspend fun getPokemonList(limit: Int): PokemonList {
        val pokemonList = pokemonRemoteDataSource.getPokemonDTOList(limit)
        val names = PokemonDataMapper.PokemonsFromDTOList(pokemonList)

        val list = mutableListOf<Pokemon>()

        names.forEach { name ->
            val pokemonDTO = pokemonRemoteDataSource.getPokemonDTO(name)
            list.add(PokemonDataMapper.PokemonFromDTO(pokemonDTO))
        }
        return PokemonList(list)
    }
}
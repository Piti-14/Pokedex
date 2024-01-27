package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedex.domain.models.PokemonList
import com.example.pokedex.domain.repositories.PokemonListRepository
import com.example.pokedex.mappers.PokemonDataMapper
import javax.inject.Inject


class PokemonListRepositoryImpl @Inject constructor(val pokemonRemoteDataSource: PokemonRemoteDataSource):
    PokemonListRepository {
    override suspend fun getPokemonList(): PokemonList {
        val pokemonList = pokemonRemoteDataSource.getListPokemonDTO()
        return PokemonDataMapper.PokemonsFromDTOList(pokemonList)
    }

}

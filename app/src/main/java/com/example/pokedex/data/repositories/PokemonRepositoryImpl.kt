package com.example.pokedex.data.repositories

import com.example.pokedex.data.sources.local.PokemonLocalDataSource
import com.example.pokedex.data.sources.remote.DTOs.PokemonDTO
import com.example.pokedex.domain.repositories.PokemonDetailRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonLocalDataSource: PokemonLocalDataSource): PokemonDetailRepository{
    //El return se iria a un mapper para crear NUESTRO modelo Pokemon del domain
    override suspend fun getPokemon(filename: String): PokemonDTO {
        return pokemonLocalDataSource.getPokemonFromJSON("ditto.json")
    }
}